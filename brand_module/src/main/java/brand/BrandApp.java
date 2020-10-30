package brand;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(basePackages = {"brand.dao"})
@SpringBootApplication
public class BrandApp {

    public static void main(String[] args) {
        SpringApplication.run(BrandApp.class);
    }
}
