package com.rabbiter.pm.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**配置 MyBatis-Plus 的分页插件 PaginationInterceptor，并根据条件 PaginationInterceptor 类的存在性来决定是否加载这个配置类。
 * 同时，通过 @MapperScan 注解指定了 Mapper 接口的扫描路径。
 * Mybatis-plus 配置文件
 */
@Configuration
@MapperScan("${mybatis-plus.mapper-package}")
@ConditionalOnClass(value = {PaginationInterceptor.class})
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
