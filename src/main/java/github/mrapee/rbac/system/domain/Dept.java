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
@TableName("t_dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = -4037693384499158065L;

    /**
    *部门id
    */
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Long deptId;

    /**
    *上级部门id
    */
    private Long parentId;

    /**
    *部门名称
    */
    @NotBlank(message = "{required}")
    @Size(max = 20,message = "{noMoreThan}")
    private String deptName;

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


}
