package javahack.raif.borsch.domain;

import com.datastax.driver.core.DataType;
import javahack.raif.borsch.domain.ids.CardTransactionId;
import javahack.raif.borsch.enums.TransactionStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Сущность "Транзакция карты" с мета-описанием таблицы.
 *
 * @author denrus
 * 14.09.2019
 */
@Data
@AllArgsConstructor
@Table("card_transaction")
public class CardTransaction {
    @PrimaryKey
    private CardTransactionId id;
    @Column("amount")
    private Double amount;
    @Column("status")
    @CassandraType(type = DataType.Name.TEXT)
    private TransactionStatusEnum status;
    @Column("date")
    private LocalDate date;
    @Column("changed")
    private LocalDateTime changed;
    @Column("message")
    private String bankMessage;
    @Column("receiver_name")
    private String receiverName;
    @Column("receiver_id")
    private UUID receiverId;
    @Column("payment_purpose")
    private String paymentPurpose;


}
