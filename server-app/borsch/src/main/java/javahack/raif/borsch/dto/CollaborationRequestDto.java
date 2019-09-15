package javahack.raif.borsch.dto;

import com.datastax.driver.core.DataType;
import javahack.raif.borsch.domain.CollaborationRequest;
import javahack.raif.borsch.domain.Recommendation;
import javahack.raif.borsch.enums.CollaborationRequestStatus;
import javahack.raif.borsch.enums.CollaborationRequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollaborationRequestDto {

    private UUID fromUserId;
    private UUID toUserId;
    private String userToName;
    private String userFromName;
    private UUID id;
    private LocalDate date;
    private String message;
    private CollaborationRequestStatus status;
    private CollaborationRequestType type;

    public CollaborationRequestDto(CollaborationRequest col) {
        this.fromUserId = col.getId().getUserFromId();
        this.toUserId = col.getId().getUserToId();
        this.id = col.getId().getId();
        this.date = col.getDate();
        this.message = col.getMessage();
        this.status = col.getStatus();
        this.type = col.getType();
        this.userFromName = col.getUserFromName();
        this.userToName = col.getUserToName();
    }

}
