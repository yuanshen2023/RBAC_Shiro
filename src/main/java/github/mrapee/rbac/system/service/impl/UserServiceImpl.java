package github.mrapee.rbac.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import github.mrapee.rbac.common.domain.QueryRequest;
import github.mrapee.rbac.system.dao.UserRoleMapper;
import github.mrapee.rbac.system.domain.User;
import github.mrapee.rbac.system.dao.UserMapper;
import github.mrapee.rbac.system.domain.UserRole;
import github.mrapee.rbac.system.service.IUserConfigService;
import github.mrapee.rbac.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
*@author:MrApee
*/
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{

    private UserRoleMapper userRoleMapper;
    private IUserConfigService userConfigService;


    @Autowired
    public UserServiceImpl(UserRoleMapper userRoleMapper,IUserConfigService userConfigService){
        this.userRoleMapper = userRoleMapper;
        this.userConfigService = userConfigService;
    }

    @Override
    public User findByName(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername,username));
    }

    @Override
    public IPage<User> findUserDetail(User user, QueryRequest queryRequest) {
        Page<User> page = new Page<>();
        page.setCurrent(queryRequest.getPageNum());
        page.setSize(queryRequest.getPageSize());
        if (StringUtils.equalsIgnoreCase(queryRequest.getSortOrder(),"desc")){
            page.setDesc(queryRequest.getSortField());
        }else page.setAsc(queryRequest.getSortField());
        return baseMapper.findUserDetail(page,user);
    }

    @Override
    @Transactional
    public void updateLoginTime(String username) throws Exception {
        User user = new User();
        user.setLastLoginTime(LocalDateTime.now());
        this.baseMapper.update(user,new LambdaQueryWrapper<User>().eq(User::getUsername,username));

        //重新将用户信息加载到redis中
        //cacheService.saveUser(username);
    }

    @Override
    @Transactional
    public void updateUser(User user) throws Exception {
        //更新用户
        user.setPassword(null);
        user.setModifyTime(LocalDateTime.now());
        updateById(user);
        userRoleMapper.deleteByUserId(user.getUserId());
        userRoleMapper.delete(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId,user.getUserId()));

        String[] roles = user.getRoleId().split(StringPool.COMMA);
        setUserRoles(user,roles);

        //重新将用户信息，用户角色信息，用户权限信息，加载到redis中
    }

    @Override
    @Transactional
    public void createUser(User user) throws Exception {
        //创建用户
        user.setAvatar(User.DEFAULT_AVATAR);
        user.setPassword(User.DEFAULT_PASSWORD);
        user.setCreateTime(LocalDateTime.now());
        user.setStatus(User.STATUS_VALID);
        save(user);

        //保存用户角色
        String[] roles = user.getRoleId().split(StringPool.COMMA);
        setUserRoles(user,roles);

        //创建用户默认的个性化配置
        userConfigService.initDefaultUserConfig(String.valueOf(user.getUserId()));

        //将用户相关信息保存到Redis中

    }

    @Override
    @Transactional
    public void deleteUsers(String[] userIds) throws Exception {
        //先删除相应的缓存

        List<String> list = Arrays.asList(userIds);
        removeByIds(list);

        //删除用户角色
        this.userRoleMapper.delete(new LambdaQueryWrapper<UserRole>().in(UserRole::getUserId,userIds));
        //删除用户个性化配置
        userConfigService.deleteByUserId(userIds);
    }

    @Override
    @Transactional
    public void updateProfile(User user) throws Exception {
        updateById(user);
        //重新缓存用户信息

    }

    @Override
    @Transactional
    public void updateAvatar(String username, String avatar) throws Exception {
        User user = new User();
        user.setAvatar(avatar);
        update(user,new LambdaQueryWrapper<User>().eq(User::getUsername,username));
        //重新缓存用户信息

    }

    @Override
    @Transactional
    public void updatePassword(String username, String password) throws Exception {
        User user = new User();
        user.setPassword(password);
        update(user,new LambdaQueryWrapper<User>().eq(User::getUsername,username));
        //重新缓存用户信息

    }

    @Override
    @Transactional
    public void regist(String username, String password) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setCreateTime(LocalDateTime.now());
        user.setAvatar(User.DEFAULT_AVATAR);
        user.setStatus(User.STATUS_VALID);
        user.setSsex(User.SEX_UNKNOWN);
        user.setDescription("注册用户");
        this.save(user);

        //添加用户角色信息
        UserRole ur = new UserRole();
        ur.setUserId(user.getUserId());
        ur.setRoleId(2L);//注册用户角色ID
        this.userRoleMapper.insert(ur);

        //创建用户默认的个性化配置
        userConfigService.initDefaultUserConfig(String.valueOf(user.getUserId()));
        //将用户相关信息保存到Redis中

    }

    @Override
    @Transactional
    public void resetPassword(String[] usernames) throws Exception {
        Arrays.stream(usernames).forEach(username -> {
            User user = new User();
            user.setPassword(User.DEFAULT_PASSWORD);
            this.baseMapper.update(user,new LambdaQueryWrapper<User>().eq(User::getUsername,username));
            //重新将用户信息加载到Redis中

        });
    }

    private void setUserRoles(User user,String[] roleIds){
        Arrays.stream(roleIds).forEach(roleId -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(Long.parseLong(roleId));
            this.userRoleMapper.insert(userRole);
        });
    }
}
