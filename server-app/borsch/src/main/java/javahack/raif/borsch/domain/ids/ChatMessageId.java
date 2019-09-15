package javahack.raif.borsch.domain.ids;

import com.datastax.driver.core.DataType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.UUID;

/**
 * Идентификатор сущности "Сообщения чата".
 *
 * @author denrus
 * 14.09.2019
 */
@Data
@PrimaryKeyClass
@EqualsAndHashCode
@AllArgsConstructor
public class ChatMessageId {
    /**
     * Основной кейс - получения чата по конкретному "взаимодействию" двух пользователей.
     * Поэтому request_id - PK
     */
    @PrimaryKeyColumn(name = "request_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID requestId;

    /**
     * Может быть кейс получения сообщений только одного пользователя для Чата. user_id - первая часть CK
     */
    @PrimaryKeyColumn(name = "user_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.UUID)
    private UUID userId;

    /**
     * Идентификатор сообщения - для обеспечения уникальности.
     */
    @PrimaryKeyColumn(name = "message_id", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.TIMEUUID)
    private UUID msgId;
}
