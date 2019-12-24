package github.mrapee.rbac.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
*
*
*@author:MrApee
*/
@Data
@TableName("t_role_menu")
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 4244827427803808540L;
    /**
    *角色id
    */
    private Long roleId;

    /**
    *菜单/按钮id
    */
    private Long menuId;


}
