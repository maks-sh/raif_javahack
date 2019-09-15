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
 * Идентификатор сущности "Рекоммендация взаимодействия".
 *
 * @author denrus
 * 14.09.2019
 */
@Data
@PrimaryKeyClass
@EqualsAndHashCode
@AllArgsConstructor
public class RecommendationId implements Serializable {
    /**
     * Основной кейс доступа - получения (и сохранение из модели) рекомендаций для конкретного пользователя.
     * Поэтому user_id - PK.
     */
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID userId;

    /**
     * Возможный кейс доступа - получения рекомендаций конкретного пользователя другому пользователю.
     * Поэтому recommended_user_id - первая часть CK.
     */
    @PrimaryKeyColumn(name = "recommended_user_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.UUID)
    private UUID recommendedUserId;

    /**
     * Идентификатор рекоммендации - для уникальности.
     */
    @PrimaryKeyColumn(name = "recommendation_id", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.TIMEUUID)
    private UUID recommendationId;
}
