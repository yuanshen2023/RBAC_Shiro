package github.mrapee.rbac.system.service;

import github.mrapee.rbac.system.domain.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
*@author:MrApee
*/
public interface IUserRoleService extends IService<UserRole>{
    void deleteByRoleId(String[] roleIds);

    void deleteByUserId(String[] userIds);

    List<String> findUserIdsByRoleId(String[] roleIds);
}
