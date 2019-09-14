package javahack.raif.borsch.domain;

import javahack.raif.borsch.domain.ids.CardTransactionId;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("card_transaction")
@Data
@AllArgsConstructor
public class CardTransaction {


    @PrimaryKey
    private CardTransactionId id;
//    @PrimaryKeyColumn(name = "card_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
//    private UUID cardId;
//
//    //timeuuid
//    @PrimaryKeyColumn(name = "transactionId", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
//    private UUID transactionId;


}
