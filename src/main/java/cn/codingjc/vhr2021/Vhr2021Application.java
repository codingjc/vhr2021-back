package cn.codingjc.vhr2021;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.codingjc.vhr2021.mapper")
public class Vhr2021Application {

    public static void main(String[] args) {
        SpringApplication.run(Vhr2021Application.class, args);
    }

}
