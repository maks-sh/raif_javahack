package javahack.raif.borsch.service.init;

import javahack.raif.borsch.domain.CardTransaction;
import javahack.raif.borsch.domain.ChatMessage;
import javahack.raif.borsch.domain.CollaborationRequest;
import javahack.raif.borsch.domain.Recommendation;
import javahack.raif.borsch.domain.User;
import javahack.raif.borsch.domain.UserCard;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.core.cql.CqlIdentifier;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Бин для инициализации структуры БД при работе с In-memory-db.
 *
 * @author denrus
 * 15.09.2019
 */
@Component
@Profile("local")
@RequiredArgsConstructor
public class DbDdlInitService {

    private static final Logger LOG = LogManager.getLogger("borsch.logger");

    private final CassandraAdminTemplate adminTemplate;

    @PostConstruct
    public void createTables() {
        createTableForEntity(User.class);
        createTableForEntity(CardTransaction.class);
        createTableForEntity(CollaborationRequest.class);
        createTableForEntity(ChatMessage.class);
        createTableForEntity(Recommendation.class);
        createTableForEntity(UserCard.class);
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
