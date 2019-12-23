package github.mrapee.rbac.system.service.impl;

import github.mrapee.rbac.system.entity.LoginLog;
import github.mrapee.rbac.system.mapper.LoginLogMapper;
import github.mrapee.rbac.system.service.ILoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
*@author:MrApee
*/
@Service("loginLogService")
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper,LoginLog> implements ILoginLogService{

}
