package javahack.raif.borsch.service;

import com.datastax.driver.core.utils.UUIDs;
import javahack.raif.borsch.domain.ChatMessage;
import javahack.raif.borsch.domain.ids.ChatMessageId;
import javahack.raif.borsch.dto.UserMessagesDto;
import javahack.raif.borsch.repo.ChatMessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Сервис обработки запросов по предоставлению данных по Сообщениям чата.
 *
 * @author denrus
 * 14.09.2019
 */
@Service
@RequiredArgsConstructor
public class ChatMessageDataService {

    private final ChatMessageRepo chatRepo;

    public Set<UserMessagesDto> getChatMessagesByUserId(UUID requestId, UUID userId) {
        Set<ChatMessage> userMsgs = chatRepo.findByUserId(requestId);
        return userMsgs.stream()
            .map(obj -> new UserMessagesDto(obj, userId))
            .collect(Collectors.toSet());
    }

    public UUID addMessageToChat(UUID reqId, UUID userId, String text) {
        ChatMessage msg = new ChatMessage(
            new ChatMessageId(
                reqId,
                userId,
                UUIDs.timeBased()
            ),
            text,
            LocalDateTime.now()
        );
        return chatRepo.save(msg).getId().getMsgId();
    }
}
