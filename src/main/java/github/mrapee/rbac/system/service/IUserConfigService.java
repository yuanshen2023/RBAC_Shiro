package github.mrapee.rbac.system.service;

import github.mrapee.rbac.system.domain.UserConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
*@author:MrApee
*/
public interface IUserConfigService extends IService<UserConfig>{

    /**
     * 通过用户id获取前端个性化配置
     *
     * @param userId
     * @return 前端个性化配置
     */
    UserConfig findByUserId(String userId);

    /**
     * 生成用户默认个性化配置
     *
     * @param userId
     */
    void initDefaultUserConfig(String userId);

    /**
     * 根据用户id删除个性化配置
     *
     * @param userIds 用户id数组
     */
    void deleteByUserId(String... userIds);

    /**
     * 更新用户个性化配置
     *
     * @param userConfig 用户个性化配置
     * @throws Exception
     */
    void update(UserConfig userConfig) throws Exception;

}
