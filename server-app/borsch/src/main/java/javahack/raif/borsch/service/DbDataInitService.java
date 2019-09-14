package javahack.raif.borsch.service;

import javahack.raif.borsch.domain.CardTransaction;
import javahack.raif.borsch.domain.User;
import javahack.raif.borsch.repo.CardTransactionRepo;
import javahack.raif.borsch.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.core.cql.CqlIdentifier;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DbDataInitService {

    private static final Logger LOG = LogManager.getLogger("borsch.logger");

    private final CassandraAdminTemplate adminTemplate;
    private final UserRepo userRepo;
    private final CardTransactionRepo cardTransactionRepo;

    @PostConstruct
    public void createTables() {
        Reflections reflections = new Reflections("my.project.prefix");

        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);
        allClasses.stream()
                .filter(clazz -> clazz.isAnnotationPresent(Table.class))
                .forEach(this::createTableForEntity);
        LOG.info("Все таблицы созданы");
    }

    private void createTableForEntity(Class<?> userClass) {
        String tableName = Arrays.stream(userClass.getAnnotations())
                .filter(obj -> obj instanceof Table)
                .map(obj -> (Table) obj)
                .map(Table::value)
                .filter(StringUtils::isNotBlank)
                .findFirst()
                .orElse(userClass.getSimpleName());
        adminTemplate.createTable(true, CqlIdentifier.cqlId(tableName), userClass, new HashMap<>());
        LOG.info("Таблица для сущности " + userClass.getSimpleName() + " создана.");
    }
}
