package github.mrapee.rbac.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import github.mrapee.rbac.system.domain.RoleMenu;
import github.mrapee.rbac.system.dao.RoleMenuMapper;
import github.mrapee.rbac.system.domain.UserRole;
import github.mrapee.rbac.system.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
*@author:MrApee
*/
@Service("roleMenuService")
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper,RoleMenu> implements IRoleMenuService{

    @Override
    public void deleteByRoleIds(String[] roleIds) {
        Arrays.stream(roleIds).forEach(roleId->{
            QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
            wrapper.eq("roleId",roleId);
            this.baseMapper.delete(wrapper);
        });
    }
}
