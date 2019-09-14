package javahack.raif.borsch.dto;

import javahack.raif.borsch.enums.TransactionStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardTransactionDto {

    //timeUUID
    private UUID id;
    private Double amount;
    private TransactionStatusEnum status;
    private LocalDate date;
    private LocalDateTime changed;
    private String bankMessage;
    private String receiverName;
    private UUID receiverId;
    private String paymentPurpose;

}
