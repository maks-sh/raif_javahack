package javahack.raif.borsch.service;

import javahack.raif.borsch.domain.UserCard;
import javahack.raif.borsch.dto.UserCardDto;
import javahack.raif.borsch.repo.UserCardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Сервис обработки запроса по предоставлению данных по сущности Пользователя.
 *
 * @author denrus
 * 14.09.2019
 */
@Service
@RequiredArgsConstructor
public class UserDataService {

    private final UserCardRepo userCardRepo;

    public Set<UserCardDto> getUserCardsByUserId(UUID userId) {
        Set<UserCard> cards = userCardRepo.findByUserId(userId);
        return cards.stream()
            .map(UserCardDto::new)
            .collect(Collectors.toSet());

    }

}
