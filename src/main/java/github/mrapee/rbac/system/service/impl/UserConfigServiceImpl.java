package github.mrapee.rbac.system.service.impl;

import github.mrapee.rbac.system.entity.UserConfig;
import github.mrapee.rbac.system.mapper.UserConfigMapper;
import github.mrapee.rbac.system.service.IUserConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
*@author:MrApee
*/
@Service("userConfigService")
public class UserConfigServiceImpl extends ServiceImpl<UserConfigMapper,UserConfig> implements IUserConfigService{

}