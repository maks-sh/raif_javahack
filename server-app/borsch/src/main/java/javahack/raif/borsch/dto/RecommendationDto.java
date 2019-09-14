package javahack.raif.borsch.dto;

import javahack.raif.borsch.domain.Recommendation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDto {

    private UUID id;
    private UUID userId;
    private String recommendedUserName;
    private String description;
    private String comment;
    private Set<String> tags;

    public RecommendationDto(Recommendation rec) {
        this.id = rec.getId().getRecommendationId();
        this.userId = rec.getId().getUserId();
        this.recommendedUserName = rec.getRecommendedUserName();
        this.description = rec.getDescription();
        this.comment = rec.getComment();
        this.tags = rec.getTags();
    }
}
