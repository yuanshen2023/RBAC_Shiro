package github.mrapee.rbac.system.service.impl;

import github.mrapee.rbac.system.domain.Log;
import github.mrapee.rbac.system.dao.LogMapper;
import github.mrapee.rbac.system.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
*@author:MrApee
*/
@Service("logService")
public class LogServiceImpl extends ServiceImpl<LogMapper,Log> implements ILogService{

}
