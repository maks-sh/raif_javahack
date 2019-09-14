package javahack.raif.borsch.domain;

import com.datastax.driver.core.DataType;
import javahack.raif.borsch.domain.ids.ChatMessageId;
import javahack.raif.borsch.enums.MessageSourceEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@Table("chat_message")
public class ChatMessage {
    @PrimaryKey
    private ChatMessageId id;

    @Column("msg_text")
    private String text;

    @Column("time")
    private LocalDateTime time;
}

