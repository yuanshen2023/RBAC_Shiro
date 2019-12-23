package github.mrapee.rbac.system.service.impl;

import github.mrapee.rbac.system.entity.User;
import github.mrapee.rbac.system.mapper.UserMapper;
import github.mrapee.rbac.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
*@author:MrApee
*/
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{

}
