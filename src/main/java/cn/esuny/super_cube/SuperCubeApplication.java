package cn.esuny.super_cube;

import cn.esuny.super_cube.translation.language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication()
public class SuperCubeApplication {
    public static final Logger logger = LoggerFactory.getLogger(SuperCubeApplication.class);

    public static Map<String, Object> language;

    public static void main(String[] args) {
        cn.esuny.super_cube.translation.language.INSTANCE.LoadLanguage();
        SpringApplication.run(SuperCubeApplication.class, args);
    }

}
