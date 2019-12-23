package github.mrapee.rbac.system.service.impl;

import github.mrapee.rbac.system.entity.Dict;
import github.mrapee.rbac.system.mapper.DictMapper;
import github.mrapee.rbac.system.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
*@author:MrApee
*/
@Service("dictService")
public class DictServiceImpl extends ServiceImpl<DictMapper,Dict> implements IDictService{

}
