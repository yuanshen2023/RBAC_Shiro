package github.mrapee.rbac.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
*
*
*@author:MrApee
*/
@Data
@TableName("t_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = -6968004650215058902L;

    /**
    *用户id
    */
    private Long userId;

    /**
    *角色id
    */
    private Long roleId;


}
