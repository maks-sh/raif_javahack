package javahack.raif.borsch.domain;

import javahack.raif.borsch.domain.ids.UserCardId;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

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

    @Column("number")
    private LocalDate expiry;
}
