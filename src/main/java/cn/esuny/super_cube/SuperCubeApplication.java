package cn.esuny.super_cube;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication()
public class SuperCubeApplication {
    public static final Logger logger = LoggerFactory.getLogger(SuperCubeApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SuperCubeApplication.class, args);
    }

}
