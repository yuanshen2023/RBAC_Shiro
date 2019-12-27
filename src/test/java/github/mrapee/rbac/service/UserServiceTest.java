package github.mrapee.rbac.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import github.mrapee.rbac.system.domain.User;
import github.mrapee.rbac.system.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @program: rbac_shiro
 * @description: 测试UserService类
 * @author: yuan_shen
 * @create: 2019-12-23 15:18
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void save(){
        User user = new User("ys","12345678","1", LocalDateTime.now());
        System.err.println(userService.save(user));
    }

    @Test
    public void saveByBatch(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User("ys"+i ,"12345678","1", LocalDateTime.now());
            list.add(user);
        }
        System.err.println(userService.saveBatch(list));
    }

    @Test
    public void query(){
        Calendar cal = Calendar.getInstance();
        cal.set(2019,Calendar.DECEMBER,23,15,35,0);
        Date ldt = cal.getTime();
        System.err.println(ldt);

        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lt("create_time",ldt);
        List<User> users = userService.list(qw);
        users.forEach(System.out::println);

    }

    @Test
    @Transactional
    @Rollback
    public void remove(){
        Map<String,Object> map = new HashMap<>();
        map.put("username","ys");
        System.err.println(userService.removeByMap(map));
    }

    @Test
    public void createUser() throws Exception{
        User user = new User();
        user.setUsername("test2");
        user.setEmail("1104357019@qq.com");
        user.setDescription("测试用户");
        user.setRoleName("测试用户");
        user.setRoleId("1");
        userService.createUser(user);
    }

    @Test
    @Transactional
    @Rollback
    public void deleteUsers() throws Exception{
        String[] ids = {"11","14","15"};
        userService.deleteUsers(ids);
    }

    @Test
    public void resetPassword() throws Exception{
        String[] usernames = {"test","test1","test2"};
        userService.resetPassword(usernames);
    }

}
