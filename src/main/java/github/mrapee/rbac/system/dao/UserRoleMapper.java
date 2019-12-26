package github.mrapee.rbac.system.dao;

import github.mrapee.rbac.system.domain.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
*@author MrApee
*/
public interface UserRoleMapper extends BaseMapper<UserRole>{
    /**
     * 根据用户id删除用户的角色信息
     *
     * @param userId
     * @return boolean
     */
    Boolean deleteByUserId(Long userId);

    /**
     * 根据角色id删除该角色的用户关系
     *
     * @param roleId
     * @return boolean
     */
    Boolean deleteByRoleId(Long roleId);
}
