package github.mrapee.rbac.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import github.mrapee.rbac.common.domain.QueryRequest;
import github.mrapee.rbac.system.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
*@author:MrApee
*/
public interface IRoleService extends IService<Role>{

    /**
     * 根据条件查询角色
     *
     * @param role
     * @param request
     * @return 分页信息
     */
    IPage<Role> findRoles(Role role, QueryRequest request);

    /**
     * 根据用户名查询用户相关角色
     * @param username
     * @return 用户的角色集
     */
    List<Role> findUserRole(String username);

    /**
     * 根据角色名查询角色信息
     * @param roleName
     * @return 角色信息
     */
    Role findByName(String roleName);

    /**
     * 创建角色
     * @param role
     */
    void createRole(Role role);

    /**
     * 根据角色id删除角色
     * @param roleIds
     * @throws Exception
     */
    void deleteRole(String[] roleIds) throws Exception;

    /**
     * 修改角色信息
     * @param role
     * @throws Exception
     */
    void updateRole(Role role) throws Exception;

}
