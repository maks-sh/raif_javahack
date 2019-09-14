package javahack.raif.borsch.repo;

import javahack.raif.borsch.domain.CardTransaction;
import javahack.raif.borsch.domain.ids.CardTransactionId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardTransactionRepo extends CassandraRepository<CardTransaction, CardTransactionId> {

}
