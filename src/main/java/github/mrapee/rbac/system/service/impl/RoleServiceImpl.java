package github.mrapee.rbac.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import github.mrapee.rbac.common.domain.QueryRequest;
import github.mrapee.rbac.system.domain.Role;
import github.mrapee.rbac.system.dao.RoleMapper;
import github.mrapee.rbac.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@author:MrApee
*/
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements IRoleService{

    /**
     * 根据条件查询角色
     *
     * @param role
     * @param request
     * @return 分页信息
     */
    @Override
    public IPage<Role> findRoles(Role role, QueryRequest request) {
        return null;
    }

    /**
     * 根据用户名查询用户相关角色
     *
     * @param username
     * @return 用户的角色集
     */
    @Override
    public List<Role> findUserRole(String username) {
        return null;
    }

    /**
     * 根据角色名查询角色信息
     *
     * @param roleName
     * @return 角色信息
     */
    @Override
    public Role findByName(String roleName) {
        return null;
    }

    /**
     * 创建角色
     *
     * @param role
     */
    @Override
    public void createRole(Role role) {

    }

    /**
     * 根据角色id删除角色
     *
     * @param roleIds
     * @throws Exception
     */
    @Override
    public void deleteRole(String[] roleIds) throws Exception {

    }

    /**
     * 修改角色信息
     *
     * @param role
     * @throws Exception
     */
    @Override
    public void updateRole(Role role) throws Exception {

    }
}
