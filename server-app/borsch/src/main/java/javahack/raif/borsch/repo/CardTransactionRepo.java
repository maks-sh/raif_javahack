package javahack.raif.borsch.repo;

import javahack.raif.borsch.domain.CardTransaction;
import javahack.raif.borsch.domain.UserCard;
import javahack.raif.borsch.domain.ids.CardTransactionId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;


@Repository
public interface CardTransactionRepo extends CassandraRepository<CardTransaction, CardTransactionId> {

    @Query("select * from card_transaction where card_id = ?0")
    Set<CardTransaction> findByCardId(UUID cardId);

}
