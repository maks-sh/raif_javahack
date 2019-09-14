package javahack.raif.borsch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yml")
public class BorschApplication {

    public static void main(String[] args) {
        SpringApplication.run(BorschApplication.class, args);
    }

}
