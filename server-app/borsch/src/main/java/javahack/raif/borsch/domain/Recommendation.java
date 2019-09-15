package javahack.raif.borsch.domain;

import javahack.raif.borsch.domain.ids.RecommendationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;

/**
 * Сущность "Рекоммендация пользователя" с мета-описанием таблицы.
 *
 * @author denrus
 * 14.09.2019
 */
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

    @Column("recommended_user_url")
    private String recommendedUserUrl;

    @Column("tags")
    private Set<String> tags;
}
