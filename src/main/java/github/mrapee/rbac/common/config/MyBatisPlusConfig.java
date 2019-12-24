package github.mrapee.rbac.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rbac_shiro
 * @description: MyBatisPlusConfig相关配置
 * @author: yuan_shen
 * @create: 2019-12-23 14:32
 **/
@Configuration
@MapperScan("github.mrapee.rbac.*.dao")
public class MyBatisPlusConfig {
    /**
    *@Description: 分页插件
    */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
