package github.mrapee.rbac.system.service.impl;

import github.mrapee.rbac.system.entity.Dept;
import github.mrapee.rbac.system.mapper.DeptMapper;
import github.mrapee.rbac.system.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
*@author:MrApee
*/
@Service("deptService")
public class DeptServiceImpl extends ServiceImpl<DeptMapper,Dept> implements IDeptService{

}
