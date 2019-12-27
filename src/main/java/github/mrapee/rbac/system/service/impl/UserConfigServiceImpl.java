package github.mrapee.rbac.system.service.impl;

import github.mrapee.rbac.system.domain.User;
import github.mrapee.rbac.system.domain.UserConfig;
import github.mrapee.rbac.system.dao.UserConfigMapper;
import github.mrapee.rbac.system.service.IUserConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
*@author:MrApee
*/
@Service("userConfigService")
public class UserConfigServiceImpl extends ServiceImpl<UserConfigMapper,UserConfig> implements IUserConfigService{


    @Override
    public UserConfig findByUserId(String userId) {
        return this.baseMapper.selectById(userId);
    }

    @Override
    @Transactional
    public void initDefaultUserConfig(String userId) {
        UserConfig userConfig = new UserConfig();
        userConfig.setUserId(Long.parseLong(userId));
        userConfig.setColor(UserConfig.DEFAULT_COLOR);
        userConfig.setFixHeader(UserConfig.DEFAULT_FIX_HEADER);
        userConfig.setFixSiderbar(UserConfig.DEFAULT_FIX_SIDERBAR);
        userConfig.setLayout(UserConfig.DEFAULT_LAYOUT);
        userConfig.setTheme(UserConfig.DEFAULT_THEME);
        userConfig.setMultiPage(UserConfig.DEFAULT_MULTIPAGE);
        baseMapper.insert(userConfig);
    }

    @Override
    @Transactional
    public void deleteByUserId(String... userIds) {
        List<String> list = Arrays.asList(userIds);
        baseMapper.deleteBatchIds(list);
    }

    @Override
    @Transactional
    public void update(UserConfig userConfig) throws Exception {
        baseMapper.updateById(userConfig);
        //将修改后的用户配置写入Redis

    }
}
