package javahack.raif.borsch.repo;

import javahack.raif.borsch.domain.Recommendation;
import javahack.raif.borsch.domain.User;
import javahack.raif.borsch.domain.ids.RecommendationId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface RecommendationRepo extends CassandraRepository<Recommendation, RecommendationId> {

    @Query("select * from recommendation where user_id = ?0 limit ?1")
    Set<Recommendation> findAllByUserIdWithLimit(UUID userId, Integer limit);
}
