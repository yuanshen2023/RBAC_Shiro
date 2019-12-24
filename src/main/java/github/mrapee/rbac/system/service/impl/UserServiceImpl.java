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
import github.mrapee.rbac.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

/**
*@author:MrApee
*/
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{

    @Autowired
    UserRoleMapper userRoleMapper;

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
        userRoleMapper.delete(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId,user.getUserId()));

        String[] roles = user.getRoleId().split(StringPool.COMMA);
        //setUserRoles(user,roles);
    }

    @Override
    public void createUser(User user) throws Exception {

    }

    @Override
    public void deleteUsers(String[] userIds) throws Exception {

    }

    @Override
    public void updateProfile(User user) throws Exception {

    }

    @Override
    public void updateAvatar(String username, String avatar) throws Exception {

    }

    @Override
    public void updatePassword(String username, String password) throws Exception {

    }

    @Override
    public void regist(String username, String password) throws Exception {

    }

    @Override
    public void resetPassword(String[] usernames) throws Exception {

    }
}
