package github.mrapee.rbac.system.service.impl;

import github.mrapee.rbac.system.entity.Role;
import github.mrapee.rbac.system.mapper.RoleMapper;
import github.mrapee.rbac.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
*@author:MrApee
*/
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements IRoleService{

}
