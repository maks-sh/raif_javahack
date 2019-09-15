package javahack.raif.borsch.dto;

import javahack.raif.borsch.domain.ChatMessage;
import javahack.raif.borsch.enums.MessageSourceEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserMessagesDto {

    private UUID collaborationRequestId;
    private UUID userId;
    private UUID messageId;
    private String text;
    private MessageSourceEnum source;
    private LocalDateTime time;

    public UserMessagesDto(ChatMessage msg, UUID userId) {
        this.collaborationRequestId = msg.getId().getRequestId();
        this.userId = msg.getId().getUserId();
        this.messageId = msg.getId().getMsgId();
        this.text = msg.getText();
        this.source = Objects.equals(this.userId, userId)
                ? MessageSourceEnum.MY
                : MessageSourceEnum.EXT;
        this.time = msg.getTime();

    }
}
