package javahack.raif.borsch.service.init;

import javahack.raif.borsch.domain.CardTransaction;
import javahack.raif.borsch.domain.Recommendation;
import javahack.raif.borsch.domain.User;
import javahack.raif.borsch.domain.UserCard;
import javahack.raif.borsch.domain.ids.UserCardId;
import javahack.raif.borsch.enums.FundType;
import javahack.raif.borsch.repo.CardTransactionRepo;
import javahack.raif.borsch.repo.RecommendationRepo;
import javahack.raif.borsch.repo.UserCardRepo;
import javahack.raif.borsch.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.UUID;

import static javahack.raif.borsch.service.init.data.CardTransactionsDataGenerator.TRANSACTIONS;
import static javahack.raif.borsch.service.init.data.RecommendationsDataGenerator.RECOMMENDATIONS;
import static javahack.raif.borsch.service.init.data.UserDataGenerator.USERS;

@Component
@RequiredArgsConstructor
public class DbDmInitService {

    private static final Logger LOG = LogManager.getLogger("borsch.logger");

    private final DbDdlInitService ddlInitService;
    private final UserRepo userRepo;
    private final UserCardRepo userCardRepo;
    private final CardTransactionRepo transactionRepo;
    private final RecommendationRepo recommendationRepo;

    public final static UUID USER_ID = UUID.fromString("743f885c-d740-11e9-8a34-2a2ae2dbcce4");

    @PostConstruct
    public void insertEntities() {
        for (User user : USERS) {
            userRepo.save(user);
        }
        //Инициализируем "основного" пользователя для демо
        userRepo.save(
            new User(USER_ID, "TODO", "Елена Жуковская")
        );
        userCardRepo.save(new UserCard(
                new UserCardId(USER_ID, UUID.fromString("e06f64c7-cc15-486b-ba3b-bd90cc31dbcb")),
                "4627 **** **** 1765",
                "Основная",
                LocalDate.now(),
                120006.87,
                FundType.RUB
        ));
        userCardRepo.save(new UserCard(
                new UserCardId(USER_ID, UUID.fromString("aee85a4a-403b-4769-9090-cb0c1273966f")),
                "5536 **** **** 1874",
                "Для поездок",
                LocalDate.now(),
                1232.15,
                FundType.RUB
        ));
        for (CardTransaction thx : TRANSACTIONS) {
            transactionRepo.save(thx);
        }


        for (Recommendation rec : RECOMMENDATIONS) {
            recommendationRepo.save(rec);
        }
    }
}