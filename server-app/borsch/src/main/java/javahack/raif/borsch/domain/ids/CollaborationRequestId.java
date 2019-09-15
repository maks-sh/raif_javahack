package javahack.raif.borsch.domain.ids;

import com.datastax.driver.core.DataType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.UUID;

/**
 * Идентификатор сущности "Запрос на взаимодействие".
 *
 * @author denrus
 * 14.09.2019
 */
@Data
@PrimaryKeyClass
@EqualsAndHashCode
@AllArgsConstructor
public class CollaborationRequestId implements Serializable {
    /**
     * Основной кейс доступа к таблице - получения "Запросов на взаимодействие" для конкретного пользователя.
     * Поэтому user_to_id - PK.
     */
    @PrimaryKeyColumn(name = "user_to_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID userToId;

    /**
     * Возможен кейс получения всех взаимодействий двух пользователей.
     * Поэтому user_from_id - первая часть CK.
     */
    @PrimaryKeyColumn(name = "user_from_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.UUID)
    private UUID userFromId;

    /**
     * Идентификатор запроса - для обеспечения уникальности.
     */
    @PrimaryKeyColumn(name = "id", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
}
