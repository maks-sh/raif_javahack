package javahack.raif.borsch.dto;

import javahack.raif.borsch.enums.FundType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCardDto {
    private UUID id;
    private String number;
    private String name;
    private LocalDate expiry;
    private Boolean focused;
    private String cvc;
    private Double funds;
    private FundType fundsType;

    private Set<CardTransactionDto> transactions;

}
