package github.mrapee.rbac.system.service.impl;

import github.mrapee.rbac.system.domain.Dept;
import github.mrapee.rbac.system.dao.DeptMapper;
import github.mrapee.rbac.system.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
*@author:MrApee
*/
@Service("deptService")
public class DeptServiceImpl extends ServiceImpl<DeptMapper,Dept> implements IDeptService{

}
