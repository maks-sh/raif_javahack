package javahack.raif.borsch.repo;

import javahack.raif.borsch.domain.ChatMessage;
import javahack.raif.borsch.domain.UserCard;
import javahack.raif.borsch.domain.ids.ChatMessageId;
import javahack.raif.borsch.domain.ids.UserCardId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface ChatMessageRepo extends CassandraRepository<ChatMessage, ChatMessageId> {

    @Query("select * from chat_message where user_id = ?")
    Set<ChatMessage> findByUserId(UUID requestId);
}
