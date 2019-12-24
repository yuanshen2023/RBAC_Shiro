package github.mrapee.rbac.system.controller;

import github.mrapee.rbac.common.controller.BaseController;
import github.mrapee.rbac.common.domain.QueryRequest;
import github.mrapee.rbac.system.domain.User;
import github.mrapee.rbac.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
* @author MrApee
*/
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    private IUserService userService;
    @Autowired
    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping
    public Map<String,Object> userList(QueryRequest queryRequest, User user){
        return getDataTable(userService.findUserDetail(user,queryRequest));
    }
}
