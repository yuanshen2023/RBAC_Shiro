package github.mrapee.rbac.system.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
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
@TableName("t_log")
public class Log implements Serializable {

    private static final long serialVersionUID = 2572138309755593468L;
    /**
    *操作用户
    */
    private String username;

    /**
    *操作内容
    */
    private String operation;

    /**
    *操作耗时
    */
    private BigDecimal time;

    /**
    *操作方法
    */
    private String method;

    /**
    *方法参数
    */
    private String params;

    /**
    *操作者ip
    */
    private String ip;

    /**
    *创建时间
    */
    private LocalDateTime createTime;

    /**
    *操作地点
    */
    private String location;

    private transient String createTimeFrom;
    private transient String createTimeTo;

}
