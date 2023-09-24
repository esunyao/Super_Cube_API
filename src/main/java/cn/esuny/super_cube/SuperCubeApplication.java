package cn.esuny.super_cube;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SuperCubeApplication {
    public static final Logger logger = LoggerFactory.getLogger(SuperCubeApplication.class);
    public static void main(String[] args) {
        logger.info("""
                \n .----------------.  .----------------.  .----------------.  .-----------------. .----------------.
                | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |
                | |  _________   | || |    _______   | || | _____  _____ | || | ____  _____  | || |  ____  ____  | |
                | | |_   ___  |  | || |   /  ___  |  | || ||_   _||_   _|| || ||_   \\|_   _| | || | |_  _||_  _| | |
                | |   | |_  \\_|  | || |  |  (__ \\_|  | || |  | |    | |  | || |  |   \\ | |   | || |   \\ \\  / /   | |
                | |   |  _|  _   | || |   '.___`-.   | || |  | '    ' |  | || |  | |\\ \\| |   | || |    \\ \\/ /    | |
                | |  _| |___/ |  | || |  |`\\____) |  | || |   \\ `--' /   | || | _| |_\\   |_  | || |    _|  |_    | |
                | | |_________|  | || |  |_______.'  | || |    `.__.'    | || ||_____|\\____| | || |   |______|   | |
                | |              | || |              | || |              | || |              | || |              | |
                | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |
                 '----------------'  '----------------'  '----------------'  '----------------'  '----------------'""");
        SpringApplication.run(SuperCubeApplication.class, args);
    }

}
