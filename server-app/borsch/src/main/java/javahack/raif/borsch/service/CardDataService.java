package javahack.raif.borsch.service;

import javahack.raif.borsch.domain.CardTransaction;
import javahack.raif.borsch.domain.User;
import javahack.raif.borsch.domain.UserCard;
import javahack.raif.borsch.dto.CardTransactionDto;
import javahack.raif.borsch.dto.UserCardDto;
import javahack.raif.borsch.repo.CardTransactionRepo;
import javahack.raif.borsch.repo.UserCardRepo;
import javahack.raif.borsch.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Сервис обработки запросов по предоставлению данных по Картам пользователя.
 *
 * @author denrus
 * 14.09.2019
 */
@Service
@RequiredArgsConstructor
public class CardDataService {

    private final CardTransactionRepo transactionRepo;

    public Set<CardTransactionDto> getCardTransactionsByCardId(UUID cardId) {
        Set<CardTransaction> transactions = transactionRepo.findByCardId(cardId);
        return transactions.stream()
            .map(CardTransactionDto::new)
            .collect(Collectors.toSet());
    }

}
