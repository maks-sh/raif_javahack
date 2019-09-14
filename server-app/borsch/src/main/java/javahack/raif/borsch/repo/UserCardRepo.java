package javahack.raif.borsch.repo;

import javahack.raif.borsch.domain.UserCard;
import javahack.raif.borsch.domain.ids.UserCardId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface UserCardRepo extends CassandraRepository<UserCard, UserCardId> {

    @Query("select * from user_card where user_id = ?")
    Set<UserCard> findByUserId(UUID userId);
}
