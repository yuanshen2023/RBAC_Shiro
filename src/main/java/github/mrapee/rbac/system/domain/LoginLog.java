package github.mrapee.rbac.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;

/**
*
*
*@author:MrApee
*/
@Data
@TableName("t_login_log")
public class LoginLog implements Serializable {

    private static final long serialVersionUID = 5627768100474061397L;
    /**
    *用户名
    */
    private String username;

    /**
    *登录时间
    */
    private LocalDateTime loginTime;

    /**
    *登录地点
    */
    private String location;

    /**
    *ip地址
    */
    private String ip;


}
