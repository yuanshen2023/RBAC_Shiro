package github.mrapee.rbac.common.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: rbac_shiro
 * @description: 所有的controller都继承该类
 * @author: yuan_shen
 * @create: 2019-12-23 17:09
 **/

public class BaseController {
    protected Map<String,Object> getDataTable(IPage<?> pageInfo){
        Map<String,Object> rspData = new HashMap<>();
        rspData.put("rows",pageInfo.getRecords());
        rspData.put("total",pageInfo.getTotal());
        return rspData;
    }
}
