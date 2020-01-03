package github.mrapee.rbac.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import github.mrapee.rbac.common.domain.QueryRequest;
import github.mrapee.rbac.system.dao.RoleMenuMapper;
import github.mrapee.rbac.system.dao.UserRoleMapper;
import github.mrapee.rbac.system.domain.Role;
import github.mrapee.rbac.system.dao.RoleMapper;
import github.mrapee.rbac.system.domain.RoleMenu;
import github.mrapee.rbac.system.domain.UserRole;
import github.mrapee.rbac.system.service.IRoleMenuService;
import github.mrapee.rbac.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import github.mrapee.rbac.system.service.IUserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
*@author:MrApee
*/
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements IRoleService{

    @Autowired
    RoleMenuMapper roleMenuMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    IUserRoleService userRoleService;
    @Autowired
    IRoleMenuService roleMenuService;

    /**
     * 根据条件查询角色
     *
     * @param role 角色
     * @param request 分页信息
     * @return 分页信息
     */
    @Override
    public IPage<Role> findRoles(Role role, QueryRequest request) {
        try{
            LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
            if (StringUtils.isNotBlank(role.getRoleName())){
                wrapper.eq(Role::getRoleName,role.getRoleName());
            }
            if (StringUtils.isNotBlank(role.getCreateTimeFrom()) && StringUtils.isNotBlank(role.getCreateTimeTo())){
                wrapper.ge(Role::getCreateTime,role.getCreateTimeFrom())
                        .le(Role::getCreateTime,role.getCreateTimeTo());
            }
            Page<Role> page = new Page<>();
            page.setCurrent(request.getPageNum());
            page.setSize(request.getPageSize());
            if (StringUtils.equalsIgnoreCase(request.getSortOrder(),"desc")){
                page.setDesc(request.getSortField());
            }else page.setAsc(request.getSortField());

            return this.page(page,wrapper);
        }catch (Exception e){
            log.error("获取角色信息失败",e);
            return null;
        }
    }

    /**
     * 根据用户名查询用户相关角色
     *
     * @param username 用户名
     * @return 用户的角色集
     */
    @Override
    public List<Role> findUserRole(String username) {
        return this.baseMapper.findByUsername(username);
    }

    /**
     * 根据角色名查询角色信息
     *
     * @param roleName 角色名
     * @return 角色信息
     */
    @Override
    public Role findByName(String roleName) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("roleName",roleName);
        return this.baseMapper.selectOne(wrapper);
    }

    /**
     * 创建角色
     *
     * @param role 角色
     */
    @Override
    @Transactional
    public void createRole(Role role) {
        role.setCreateTime(LocalDateTime.now());
        this.save(role);

        String[] menuIds = role.getMenuId().split(StringPool.COMMA);
        setRoleMenus(role,menuIds);
    }

    /**
     * 根据角色id删除角色
     *
     * @param roleIds 角色id
     * @throws Exception
     */
    @Override
    @Transactional
    public void deleteRole(String[] roleIds) throws Exception {
        //查找这些角色关联的用户
        List<String> userIds = this.userRoleService.findUserIdsByRoleId(roleIds);

        //删除角色表记录
        this.baseMapper.deleteBatchIds(Arrays.asList(roleIds));

        //删除角色菜单表记录
        roleMenuService.deleteByRoleIds(roleIds);

        //删除用户角色表记录
        userRoleService.deleteByRoleId(roleIds);

        //重新将用户的角色和权限缓存到Redis中


    }

    /**
     * 修改角色信息
     *
     * @param role 角色
     * @throws Exception
     */
    @Override
    @Transactional
    public void updateRole(Role role) throws Exception {
        //查找角色关联的用户信息
        String[] roleId = {String.valueOf(role.getRoleId())};
        List<String> userIds = this.userRoleService.findUserIdsByRoleId(roleId);

        role.setModifyTime(LocalDateTime.now());
        this.baseMapper.updateById(role);

        roleMenuMapper.delete(new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getRoleId,role.getRoleId()));

        String[] menuIds = role.getMenuId().split(StringPool.COMMA);
        setRoleMenus(role,menuIds);


        //将用户的角色和权限信息重新写入Redis

    }

    private void setRoleMenus(Role role,String[] menuIds){
        Arrays.stream(menuIds).forEach(menuId->{
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(role.getRoleId());
            roleMenu.setMenuId(Long.parseLong(menuId));
            roleMenuMapper.insert(roleMenu);
        });
    }
}
