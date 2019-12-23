package github.mrapee.rbac.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
*
*
*@author:MrApee
*/
@Data
@TableName("t_role")
public class Role implements Serializable {

    private static final long serialVersionUID = -4603109345549730769L;

    /**
    *角色id
    */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
    *角色名称
    */
    @NotBlank(message = "{required}")
    @Size(max = 10, message = "{noMoreThan}")
    private String roleName;

    /**
    *角色描述
    */
    @Size(max = 50, message = "{noMoreThan}")
    private String remark;

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
    private transient String menuId;

}
