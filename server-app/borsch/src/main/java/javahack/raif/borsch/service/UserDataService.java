package javahack.raif.borsch.service;

import javahack.raif.borsch.domain.UserCard;
import javahack.raif.borsch.dto.UserCardDto;
import javahack.raif.borsch.repo.UserCardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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
