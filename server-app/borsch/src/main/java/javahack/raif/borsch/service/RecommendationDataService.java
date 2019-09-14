package javahack.raif.borsch.service;

import javahack.raif.borsch.domain.Recommendation;
import javahack.raif.borsch.dto.RecommendationDto;
import javahack.raif.borsch.repo.RecommendationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationDataService {

    private final RecommendationRepo recommendationRepo;

    public Set<RecommendationDto> getAllRecommendationsByUserIdWithLimit(UUID userId, Integer limit) {
        Set<Recommendation> recommendations = recommendationRepo.findAllByUserIdWithLimit(userId, limit);
        return recommendations.stream()
                .map(RecommendationDto::new)
                .collect(Collectors.toSet());

    }

}
