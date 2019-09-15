package javahack.raif.borsch.controllers;

import javahack.raif.borsch.dto.CardTransactionDto;
import javahack.raif.borsch.dto.CollaborationRequestDto;
import javahack.raif.borsch.dto.RecommendationDto;
import javahack.raif.borsch.dto.UserCardDto;
import javahack.raif.borsch.dto.UserMessagesDto;
import javahack.raif.borsch.enums.CollaborationRequestStatus;
import javahack.raif.borsch.service.CardDataService;
import javahack.raif.borsch.service.ChatMessageDataService;
import javahack.raif.borsch.service.CollaborationRequestDataService;
import javahack.raif.borsch.service.RecommendationDataService;
import javahack.raif.borsch.service.UserDataService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

/**
 * Контроллер для передачи данных на клиент.
 *
 * @author denrus
 * 15.09.2019
 */
@CrossOrigin
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class DataController {

    private final UserDataService userService;
    private final CardDataService cardService;
    private final RecommendationDataService recService;
    private final CollaborationRequestDataService colService;
    private final ChatMessageDataService msgService;


    @GetMapping("/user/{userId}/cards")
    public Set<UserCardDto> getUserCardsByUserId(@PathVariable UUID userId) {
        return userService.getUserCardsByUserId(userId);
    }

    @GetMapping("/card/{cardId}/transactions")
    public Set<CardTransactionDto> getCardTransactions(@PathVariable("cardId") UUID cardId) {
        return cardService.getCardTransactionsByCardId(cardId);
    }

    @GetMapping("/user/{userId}/recommendations")
    public Set<RecommendationDto> getAllRecommendationsByUserIdWithLimit(
        @PathVariable UUID userId,
        @RequestParam(value = "limit", defaultValue = "5") Integer limit
    ) {
        return recService.getAllRecommendationsByUserIdWithLimit(userId, limit);
    }


    @GetMapping("/user/{userId}/collaborationRequests")
    public Set<CollaborationRequestDto> getAllCollabRequestsByUserId(
        @PathVariable UUID userId
    ) {
        return colService.getCollaborationRequestsByUserId(userId);
    }

    @PutMapping("/user/{userId}/request/{userToId}")
    public String addCollaborationRequest(
        @PathVariable UUID userId,
        @PathVariable UUID userToId,
        @RequestBody String text

    ) {
        return colService.addCollaborationRequest(userId, userToId, text);
    }

    @PatchMapping("/user/{userId}/to/{userToId}/request/{id}")
    public String updateCollaborationRequestStatus(
        @PathVariable UUID userId,
        @PathVariable UUID userToId,
        @PathVariable UUID id,
        @RequestParam("status") CollaborationRequestStatus status

    ) {
        colService.updateCollaborationStatusRequestById(status, userToId, userId, id);
        return "OK";
    }


    @GetMapping("/chat/{reqId}/user/{userId}")
    public Set<UserMessagesDto> getAllChatMessages(
        @PathVariable UUID reqId,
        @PathVariable UUID userId
    ) {
        return msgService.getChatMessagesByUserId(reqId, userId);
    }

    @PutMapping("/chat/{reqId}/user/{userId}/add")
    public String addMessageToChat(
        @PathVariable UUID reqId,
        @PathVariable UUID userId,
        @RequestBody String text
    ) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msgId", msgService.addMessageToChat(reqId, userId, text).toString());
        return jsonObject.toJSONString();
    }
}
