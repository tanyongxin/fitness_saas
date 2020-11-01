package member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(basePackages = "member.dao")
@SpringBootApplication
public class MemberApp {

    public static void main(String[] args) {
        SpringApplication.run(MemberApp.class);
    }
}
