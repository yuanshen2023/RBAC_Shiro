package github.mrapee.rbac.system.dao;

import github.mrapee.rbac.system.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
*@author MrApee
*/
public interface RoleMapper extends BaseMapper<Role>{
    List<Role> findByUsername(String username);
}
