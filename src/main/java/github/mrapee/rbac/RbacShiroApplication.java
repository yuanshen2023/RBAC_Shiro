package github.mrapee.rbac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("github.mrapee.rbac.system.mapper")
@SpringBootApplication
public class RbacShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbacShiroApplication.class, args);
    }

}
