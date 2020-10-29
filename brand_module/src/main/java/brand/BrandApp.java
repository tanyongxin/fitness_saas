package brand;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(basePackages = {"brand.dao"})
@EnableDubbo
@SpringBootApplication
public class BrandApp {

    public static void main(String[] args) {
        SpringApplication.run(BrandApp.class);
    }
}
