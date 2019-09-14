package javahack.raif.borsch.dto;

import javahack.raif.borsch.domain.UserCard;
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
    private UUID userId;
    private String number;
    private String name;
    private LocalDate expiry;
    private Double funds;
    private FundType fundsType;

    public UserCardDto(UserCard card) {
        this.id = card.getId().getCardId();
        this.userId = card.getId().getUserId();
        this.number = card.getNumber();
        this.name = card.getCardName();
        this.expiry = card.getExpiry();
        //TODO funds & fundType
    }
}
