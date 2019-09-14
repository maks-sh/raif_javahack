package javahack.raif.borsch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;


@Data
@AllArgsConstructor
@Table("user")
public class UserRecommendation {
    @PrimaryKey
    UUID id;

}

