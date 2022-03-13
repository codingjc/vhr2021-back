package cn.codingjc.vhr2021;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan(basePackages = "cn.codingjc.vhr2021.mapper")
public class Vhr2021Application {

    public static void main(String[] args) {
        SpringApplication.run(Vhr2021Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }
}
