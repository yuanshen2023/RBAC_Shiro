package github.mrapee.rbac.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import github.mrapee.rbac.system.entity.User;
import github.mrapee.rbac.system.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: rbac_shiro
 * @description: 测试userMapper
 * @author: yuan_shen
 * @create: 2019-12-23 09:35
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired(required = false)
    private UserMapper userMapper;

    @org.junit.Test
    public void saveUser(){
        System.err.println(LocalDateTime.now());
        User user = new User("ys","12345678","1", LocalDateTime.now(ZoneId.systemDefault()));
        int ret = userMapper.insert(user);
        System.err.println(ret);
    }

    @Test
    public void selectList(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username","ys");
        /*查询总记录数*/
        Integer count = userMapper.selectCount(qw);
        System.err.println(count);
        //查询全部记录
        List<User> users = userMapper.selectList(null);
        users.forEach(obj -> System.err.println(obj.toString()));
    }

    @Test
    public void selectMaps(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.isNotNull("username");
        List<Map<String,Object>> maps = userMapper.selectMaps(qw);
        maps.forEach(map-> System.err.println(map));
    }

    @Test
    public void selectPage(){
        Page<User> page = new Page<>(2,5);
        QueryWrapper<User> qw = new QueryWrapper<>();

        IPage<User> userIPage = userMapper.selectPage(page,qw);
        System.err.println(userIPage.getRecords());
    }

    @Test
    public void selectMapsPage(){
        Page<User> page = new Page<>(1,3);
        QueryWrapper<User> qw = new QueryWrapper<>();
        IPage<Map<String,Object>> mapIPage = userMapper.selectMapsPage(page,qw);
        System.err.println(mapIPage.getRecords());
    }

    @Test
    @Rollback
    @Transactional
    public void delete(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.like("username","ys");
        System.err.println(userMapper.delete(qw));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("username","ys");
        System.err.println(userMapper.deleteByMap(map));
    }

}
