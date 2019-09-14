package javahack.raif.borsch.domain;

import com.datastax.driver.core.DataType;
import javahack.raif.borsch.domain.ids.CollaborationRequestId;
import javahack.raif.borsch.enums.CollaborationRequestStatus;
import javahack.raif.borsch.enums.CollaborationRequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Table("collaboration_request")
public class CollaborationRequest {

    @PrimaryKey
    private CollaborationRequestId id;

    @Column("date")
    private LocalDate date;
    @Column("message")
    private String message;
    @Column("status")
    @CassandraType(type = DataType.Name.TEXT)
    private CollaborationRequestStatus status;

}
