package javahack.raif.borsch.repo;

import javahack.raif.borsch.domain.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends CassandraRepository<User, UUID> {
}
