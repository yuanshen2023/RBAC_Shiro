package github.mrapee.rbac.system.service.impl;

import github.mrapee.rbac.system.domain.RoleMenu;
import github.mrapee.rbac.system.dao.RoleMenuMapper;
import github.mrapee.rbac.system.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
*@author:MrApee
*/
@Service("roleMenuService")
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper,RoleMenu> implements IRoleMenuService{

}
