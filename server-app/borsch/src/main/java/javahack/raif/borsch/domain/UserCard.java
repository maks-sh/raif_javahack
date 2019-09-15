package javahack.raif.borsch.domain;

import javahack.raif.borsch.domain.ids.UserCardId;
import javahack.raif.borsch.enums.FundType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

/**
 * Сущность "Карта пользователя" с мета-описанием таблицы.
 *
 * @author denrus
 * 14.09.2019
 */
@Data
@AllArgsConstructor
@Table("user_card")
public class UserCard {
    @PrimaryKey
    private UserCardId id;

    @Column("number")
    private String number;

    @Column("name")
    private String cardName;

    @Column("expiry")
    private LocalDate expiry;

    @Column("funds")
    private Double funds;

    @Column("fund_type")
    private FundType fundType;
}
