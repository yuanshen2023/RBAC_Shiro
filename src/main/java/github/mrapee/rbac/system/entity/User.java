package github.mrapee.rbac.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
*
*
*@author:MrApee
*/
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 8437856401946981478L;

    /**
    *账户状态
    */
    public static final String STATUS_VALID = "1";

    public static final String STATUS_LOCK = "0";

    public static final String DEFAULT_AVATAR = "default.jpg";

    /**
    *性别
    */
    public static final String SEX_MAIL = "0";

    public static final String SEX_FEMAIL = "1";

    public static final String SEX_UNKNOWN = "2";

    //默认密码
    public static final String DEFAULT_PASSWORD = "12345678";

    /**
    *用户id
    */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
    *用户名
    */
    @NonNull
    @Size(min = 4, max = 10, message = "{range}")
    private String username;

    /**
    *密码
    */
    @NonNull
    private String password;

    /**
    *部门id
    */
    private Long deptId;

    /**
    *邮箱
    */
    @Size(max = 50, message = "{noMoreThan}")
    @Email(message = "{email}")
    private String email;

    /**
    *联系电话
    */
    private String mobile;

    /**
    *状态 1可用 0禁用
    */
    @NonNull
    @NotBlank(message = "{required}")
    private String status;

    /**
    *创建时间
    */
    @NonNull
    private LocalDateTime createTime;

    /**
    *修改时间
    */
    private LocalDateTime modifyTime;

    /**
    *最后访问时间
    */
    private LocalDateTime lastLoginTime;

    /**
    *性别 1女 0男 2保密
    */
    @NotBlank(message = "{required}")
    private String ssex;

    /**
    *描述
    */
    @Size(max = 100, message = "{noMoreThan}")
    private String description;

    /**
    *用户头像
    */
    private String avatar;

    @NotBlank(message = "{required}")
    private transient String roleId;

    private transient String roleName;

    // 排序字段
    private transient String sortField;

    // 排序规则 ascend 升序 descend 降序
    private transient String sortOrder;

    private transient String createTimeFrom;
    private transient String createTimeTo;

    private transient String id;

    /**
     * shiro-redis v3.1.0 必须要有 getAuthCacheKey()或者 getId()方法
     * # Principal id field name. The field which you can get unique id to identify this principal.
     * # For example, if you use UserInfo as Principal class, the id field maybe userId, userName, email, etc.
     * # Remember to add getter to this id field. For example, getUserId(), getUserName(), getEmail(), etc.
     * # Default value is authCacheKey or id, that means your principal object has a method called "getAuthCacheKey()" or "getId()"
     *
     * @return userId as Principal id field name
     */
    public Long getAuthCacheKey() {
        return userId;
    }
}
