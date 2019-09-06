package com.honorzhang.mybatisplustest;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zew
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.honorzhang.mybatisplustest.mapper")
public class MybatisPlusConfig {
}
