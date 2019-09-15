package javahack.raif.borsch.domain;

import javahack.raif.borsch.domain.ids.ChatMessageId;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * Сущность "Сообщение в чате" с мета-описанием таблицы.
 *
 * @author denrus
 * 14.09.2019
 */
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

