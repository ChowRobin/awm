package pers.robin.awm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"pers.robin.awm.dao"})
@ServletComponentScan
public class AwmApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwmApplication.class, args);
    }
}
