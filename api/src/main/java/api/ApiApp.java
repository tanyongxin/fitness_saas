package api;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApiApp {

    @Reference
    BrandApi brandApi;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApiApp.class);
        context.getBean(BrandApi.class).updateBrand(null);
    }
}
