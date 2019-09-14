package javahack.raif.borsch.domain.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.UUID;

@PrimaryKeyClass
@EqualsAndHashCode
@Data
@AllArgsConstructor
public class CardTransactionId implements Serializable {
    @PrimaryKeyColumn(name = "card_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID cardId;

    //timeuuid
    @PrimaryKeyColumn(name = "transaction_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID transactionId;
}
