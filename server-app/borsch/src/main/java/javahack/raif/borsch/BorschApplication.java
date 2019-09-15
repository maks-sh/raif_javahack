package javahack.raif.borsch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Основной запускаем класс.
 * @author denrus
 * 14.09.2019
 */
@SpringBootApplication
@PropertySource("classpath:application.yml")
public class BorschApplication {

    public static void main(String[] args) {
        SpringApplication.run(BorschApplication.class, args);
    }

}
