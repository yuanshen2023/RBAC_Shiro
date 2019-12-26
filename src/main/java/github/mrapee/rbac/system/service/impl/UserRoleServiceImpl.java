package github.mrapee.rbac.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import github.mrapee.rbac.system.domain.UserRole;
import github.mrapee.rbac.system.dao.UserRoleMapper;
import github.mrapee.rbac.system.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
*@author:MrApee
*/
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRole> implements IUserRoleService{

    @Override
    @Transactional
    public void deleteByRoleId(String[] roleIds) {
        Arrays.stream(roleIds).forEach(roleId->this.baseMapper.deleteByRoleId(Long.parseLong(roleId)));
    }

    @Override
    @Transactional
    public void deleteByUserId(String[] userIds) {
        Arrays.stream(userIds).forEach(userId -> this.baseMapper.deleteByUserId(Long.parseLong(userId)));
    }

    @Override
    public List<String> findUserIdsByRoleId(String[] roleIds) {
        List<UserRole> list = baseMapper.selectList(new LambdaQueryWrapper<UserRole>().in(UserRole::getRoleId,String.join(",",roleIds)));
        //没看懂，感觉很厉害！
        return list.stream().map(userRole -> String.valueOf(userRole.getUserId())).collect(Collectors.toList());
    }
}
