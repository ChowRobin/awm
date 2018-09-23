package pers.robin.awm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"pers.robin.awm.dao"})
public class AwmApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwmApplication.class, args);
    }
}
