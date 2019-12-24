package github.mrapee.rbac.system.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import github.mrapee.rbac.system.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
*@author MrApee
*/
public interface UserMapper extends BaseMapper<User>{
    IPage<User> findUserDetail(Page page, @Param("user")User user);


}
