package javahack.raif.borsch.domain.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.UUID;

/**
 * Идентификатор сущности "Карта пользователя".
 *
 * @author denrus
 * 14.09.2019
 */
@Data
@PrimaryKeyClass
@EqualsAndHashCode
@AllArgsConstructor
public class UserCardId implements Serializable {
    /**
     * Основной кейс доступа - получение всех карт конкретного пользователя.
     * Поэтому user_id - PK
     */
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID userId;

    /**
     * Идентификатор карты - для обеспечения уникальности.
     */
    @PrimaryKeyColumn(name = "card_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID cardId;
}
