package github.mrapee.rbac.system.controller;


import com.mysql.cj.QueryResult;
import github.mrapee.rbac.common.controller.BaseController;
import github.mrapee.rbac.system.entity.User;
import github.mrapee.rbac.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
* @author MrApee
*/
@RestController
@RequestMapping("/system/user")
public class UserController extends BaseController {
    @Autowired
    public IUserService userService;

    @GetMapping
    public Map<String,Object> userList(QueryResult queryResult, User user){
        return new HashMap<>();
    }
}
