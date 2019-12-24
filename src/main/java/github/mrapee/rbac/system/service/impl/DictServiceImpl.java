package github.mrapee.rbac.system.service.impl;

import github.mrapee.rbac.system.domain.Dict;
import github.mrapee.rbac.system.dao.DictMapper;
import github.mrapee.rbac.system.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
*@author:MrApee
*/
@Service("dictService")
public class DictServiceImpl extends ServiceImpl<DictMapper,Dict> implements IDictService{

}
