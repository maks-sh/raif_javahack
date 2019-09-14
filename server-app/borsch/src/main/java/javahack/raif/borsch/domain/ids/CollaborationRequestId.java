package javahack.raif.borsch.domain.ids;

import com.datastax.driver.core.DataType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.UUID;

@PrimaryKeyClass
@EqualsAndHashCode
@Data
@AllArgsConstructor
public class CollaborationRequestId implements Serializable {
    @PrimaryKeyColumn(name = "user_to_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID userToId;

    @PrimaryKeyColumn(name = "user_from_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.UUID)
    private UUID userFromId;

    @PrimaryKeyColumn(name = "id", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
}
