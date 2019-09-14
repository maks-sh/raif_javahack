package javahack.raif.borsch.controllers;

import javahack.raif.borsch.domain.User;
import javahack.raif.borsch.repo.UserRepo;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.core.cql.CqlIdentifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

/**
 * Тестовое апи.
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
