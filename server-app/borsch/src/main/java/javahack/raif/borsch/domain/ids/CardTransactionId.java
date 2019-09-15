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
 * Идентификатор сущности "Транзакция карты".
 *
 * @author denrus
 * 14.09.2019
 */
@PrimaryKeyClass
@EqualsAndHashCode
@Data
@AllArgsConstructor
public class CardTransactionId implements Serializable {
    /**
     * Основной кейс - получение всех транзакций по карте. Поэтому card_id - PK
     */
    @PrimaryKeyColumn(name = "card_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID cardId;

    /**
     * Идентификатор транзакции - CK, для обеспечения уникальности.
     */
    @PrimaryKeyColumn(name = "transaction_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.TIMEUUID)
    private UUID transactionId;
}
