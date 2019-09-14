package javahack.raif.borsch.domain;

import javahack.raif.borsch.domain.ids.RecommendationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@Table("recommendation")
public class Recommendation {
    @PrimaryKey
    private RecommendationId id;

    @Column("name")
    private String recommendedUserName;

    @Column("description")
    private String description;

    @Column("comment")
    private String comment;

    @Column("tags")
    private Set<String> tags;
}
