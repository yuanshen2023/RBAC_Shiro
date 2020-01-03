package github.mrapee.rbac.mapper;

import github.mrapee.rbac.system.dao.RoleMapper;
import github.mrapee.rbac.system.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: rbac_shiro
 * @description: RoleMapper测试
 * @author: yuan_shen
 * @create: 2020-01-02 10:27
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {

    @Autowired
    RoleMapper roleMapper;

    @Test
    @Transactional
    @Rollback
    public void findByUsername(){
        List<Role> roles = roleMapper.findByUsername("admin");
        System.err.println(roles);
        System.err.println(roleMapper.findByUsername("custom"));
        System.err.println(roleMapper.findByUsername("guest"));

    }
}
