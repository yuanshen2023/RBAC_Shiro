package github.mrapee.rbac.system.service.impl;

import github.mrapee.rbac.system.domain.UserRole;
import github.mrapee.rbac.system.dao.UserRoleMapper;
import github.mrapee.rbac.system.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
*@author:MrApee
*/
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRole> implements IUserRoleService{

}
