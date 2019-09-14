package javahack.raif.borsch.repo;

import javahack.raif.borsch.domain.CollaborationRequest;
import javahack.raif.borsch.domain.Recommendation;
import javahack.raif.borsch.domain.ids.CollaborationRequestId;
import javahack.raif.borsch.domain.ids.RecommendationId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface CollaborationRequestRepo extends CassandraRepository<CollaborationRequest, CollaborationRequestId> {

    @Query("select * from collaboration_request where user_id = ?")
    Set<CollaborationRequest> findAllByUserId(UUID userId);

    @Query("update collaboration_request SET status = ? where user_id = ? AND user_from_id = ? and id = ?")
    Integer updateCollaborationlRequestStatusById(String status, UUID userId, UUID userFromId, UUID id);
}
