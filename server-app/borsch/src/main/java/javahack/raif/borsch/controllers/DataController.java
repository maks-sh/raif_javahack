package javahack.raif.borsch.controllers;

import javahack.raif.borsch.dto.CardTransactionDto;
import javahack.raif.borsch.dto.CollaborationRequestDto;
import javahack.raif.borsch.dto.RecommendationDto;
import javahack.raif.borsch.dto.UserCardDto;
import javahack.raif.borsch.dto.UserMessagesDto;
import javahack.raif.borsch.service.CardDataService;
import javahack.raif.borsch.service.ChatMessageDataService;
import javahack.raif.borsch.service.CollaborationRequestDataService;
import javahack.raif.borsch.service.RecommendationDataService;
import javahack.raif.borsch.service.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class DataController {

    private final UserDataService userService;
    private final CardDataService cardService;
    private final RecommendationDataService recService;
    private final CollaborationRequestDataService colService;
    private final ChatMessageDataService msgService;

    @GetMapping("user/{userId}/cards")
    public Set<UserCardDto> getUserCardsByUserId(@PathVariable UUID userId) {
        return userService.getUserCardsByUserId(userId);
    }

    @GetMapping("/card/{cardId}/transactions")
    public Set<CardTransactionDto> getCardTransactions(@PathVariable("cardId") UUID cardId) {
        return cardService.getCardTransactionsByCardId(cardId);
    }

    @GetMapping("user/{userId}/recommendations")
    public Set<RecommendationDto> getAllRecommendationsByUserIdWithLimit(
            @PathVariable UUID userId,
            @RequestParam(value = "limit", defaultValue = "5") Integer limit
    ) {
        return recService.getAllRecommendationsByUserIdWithLimit(userId, limit);
    }

    @GetMapping("chat/{reqId}/user/{userId}")
    public Set<UserMessagesDto> getAllChatMessages(
            @PathVariable UUID reqId,
            @PathVariable UUID userId
    ) {
        return msgService.getChatMessagesByUserId(reqId, userId);
    }
    @GetMapping("user/{userId}/collaborationRequests")
    public Set<CollaborationRequestDto> getAllCollabRequestsByUserId(
            @PathVariable UUID userId
    ) {
        return colService.getCollaborationRequestsByUserId(userId);
    }
    @PutMapping("user/{userId}/request/{toUserId}")
    public String addCollaborationRequest(
            @PathVariable UUID userId,
            @PathVariable UUID userToId,
            @RequestParam(value = "text") String text

    ) {
        return colService.addCollaborationRequest(userId, userToId, text).toString();
    }

    @PostMapping("chat/{reqId}/user/{userId}/add")
    public String addMessageToChat(
            @PathVariable UUID reqId,
            @PathVariable UUID userId,
            @RequestParam(value = "text") String text
    ) {
        return msgService.addMessageToChat(reqId, userId, text).toString();
    }
}
