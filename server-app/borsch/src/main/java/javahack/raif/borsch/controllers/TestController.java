package javahack.raif.borsch.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Тестовое апи.
 *
 * @author denrus
 * 14.09.2019
 */
@RestController
@RequestMapping("/test/")
public class TestController {

    private static final Logger ROOT_LOGGER = LogManager.getRootLogger();
    private static final Logger BORSCH_LOGGER = LogManager.getLogger("borsch.logger");

    @GetMapping("heartbeat")
    public String areYouAlive() {
        ROOT_LOGGER.info("Лог только в консоль");
        BORSCH_LOGGER.info("Лог и в консоль, и в файл");
        return "I`m ok";
    }


}
