package cn.esuny.super_cube;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("cn.esuny.super_cube.Mapper")
public class SuperCubeApplication {
    public static final Logger logger = LoggerFactory.getLogger(SuperCubeApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SuperCubeApplication.class, args);
    }

}
