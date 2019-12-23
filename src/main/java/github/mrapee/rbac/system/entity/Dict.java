package github.mrapee.rbac.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_dict")
public class Dict implements Serializable {

    private static final long serialVersionUID = -4430491746142067856L;

    /**
    *字典id
    */
    @TableId(value = "dict_id", type = IdType.AUTO)
    private Long dictId;

    /**
    *键
    */
    @NotBlank(message = "{required}")
    @Size(max = 10, message = "{noMoreThan}")
    private Long keyy;

    /**
    *值
    */
    @NotBlank(message = "{required}")
    @Size(max = 20, message = "{noMoreThan}")
    private String valuee;

    /**
    *字段名称
    */
    @NotBlank(message = "{required}")
    @Size(max = 20, message = "{noMoreThan}")
    private String fieldName;

    /**
    *表名
    */
    @NotBlank(message = "{required}")
    @Size(max = 20, message = "{noMoreThan}")
    private String tableName;


}
