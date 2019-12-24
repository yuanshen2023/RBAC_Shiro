package github.mrapee.rbac.common.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: rbac_shiro
 * @description: 分页查询参数
 * @author: yuan_shen
 * @create: 2019-12-24 13:51
 **/
@Data
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = 3221482705949136649L;

    /*每页数量*/
    private int pageSize = 10;
    /*查询页数*/
    private int pageNum = 1;
    /*排序字段*/
    private String sortField;
    /*排序方法ASC和DESC*/
    private String sortOrder;
}
