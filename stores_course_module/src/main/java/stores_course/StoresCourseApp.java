package stores_course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(basePackages = "stores_course.dao")
@SpringBootApplication
public class StoresCourseApp {

    public static void main(String[] args) {
        SpringApplication.run(StoresCourseApp.class);
    }
}
