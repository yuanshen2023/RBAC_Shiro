package github.mrapee.rbac.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import github.mrapee.rbac.common.domain.QueryRequest;
import github.mrapee.rbac.system.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
*@author:MrApee
*/
public interface IUserService extends IService<User>{

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return user
     */
    User findByName(String username);

    /**
     * 查询用户详情，包括基本信息，用户角色，用户部门
     *
     * @param user 用户信息
     * @param queryRequest 查询条件
     * @return IPage
     */
    IPage<User> findUserDetail(User user, QueryRequest queryRequest);

    /**
     * 更新用户登录时间
     *
     * @param username 用户名
     * @throws Exception
     */
    void updateLoginTime(String username) throws Exception;

    /**
     * 新增用户
     *
     * @param user 用户信息
     * @throws Exception
     */
    void updateUser(User user) throws Exception;

    /**
     * 修改用户
     *
     * @param user 用户信息
     * @throws Exception
     */
    void createUser(User user) throws Exception;

    /**
     * 删除用户
     *
     * @param userIds 用户id 数组
     * @throws Exception
     */
    void deleteUsers(String[] userIds) throws Exception;

    /**
     * 更新个人信息
     *
     * @param user 个人信息
     * @throws Exception
     */
    void updateProfile(User user) throws Exception;

    /**
     * 更新用户头像
     *
     * @param username 用户名
     * @param avatar 用户头像
     * @throws Exception
     */
    void updateAvatar(String username,String avatar) throws Exception;

    /**
     * 更新密码
     *
     * @param username 用户名
     * @param password 密码
     * @throws Exception
     */
    void updatePassword(String username,String password) throws Exception;

    /**
     * 注册用户
     *
     * @param username 用户名
     * @param password 密码
     * @throws Exception
     */
    void regist(String username, String password) throws Exception;

    /**
     * 重置密码（默认12345678）
     *
     * @param usernames 用户名
     * @throws Exception
     */
    void resetPassword(String[] usernames) throws Exception;
}
