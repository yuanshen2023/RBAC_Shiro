package github.mrapee.rbac.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
*
*
*@author:MrApee
*/
@Data
@TableName("t_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 5244366787166110986L;

    public static final String TYPE_MENU = "0";

    public static final String TYPE_BUTTON = "1";

    /**
    *菜单/按钮id
    */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    /**
    *上级菜单id
    */
    private Long parentId;

    /**
    *菜单/按钮名称
    */
    @NotBlank(message = "{required}")
    @Size(max = 10, message = "{noMoreThan}")
    private String menuName;

    /**
    *对应路由path
    */
    @Size(max = 50, message = "{noMoreThan}")
    private String path;

    /**
    *对应路由组件component
    */
    @Size(max = 100, message = "{noMoreThan}")
    private String component;

    /**
    *权限标识
    */
    @Size(max = 50, message = "{noMoreThan}")
    private String perms;

    /**
    *图标
    */
    private String icon;

    /**
    *类型 1按钮 0菜单
    */
    @NotBlank(message = "{required}")
    private String type;

    /**
    *排序
    */
    private Double orderNum;

    /**
    *创建时间
    */
    private LocalDateTime createTime;

    /**
    *修改时间
    */
    private LocalDateTime modifyTime;

    private transient String createTimeFrom;
    private transient String createTimeTo;

}
