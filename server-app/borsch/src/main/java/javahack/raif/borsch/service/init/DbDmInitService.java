package javahack.raif.borsch.service.init;

import com.google.common.collect.Sets;
import javahack.raif.borsch.domain.CardTransaction;
import javahack.raif.borsch.domain.Recommendation;
import javahack.raif.borsch.domain.User;
import javahack.raif.borsch.domain.UserCard;
import javahack.raif.borsch.domain.ids.CardTransactionId;
import javahack.raif.borsch.domain.ids.RecommendationId;
import javahack.raif.borsch.domain.ids.UserCardId;
import javahack.raif.borsch.enums.FundType;
import javahack.raif.borsch.enums.TransactionStatusEnum;
import javahack.raif.borsch.repo.CardTransactionRepo;
import javahack.raif.borsch.repo.RecommendationRepo;
import javahack.raif.borsch.repo.UserCardRepo;
import javahack.raif.borsch.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DbDmInitService {

    private static final Logger LOG = LogManager.getLogger("borsch.logger");

    private final DbDdlInitService ddlInitService;
    private final UserRepo userRepo;
    private final UserCardRepo userCardRepo;
    private final CardTransactionRepo transactionRepo;
    private final RecommendationRepo recommendationRepo;

    private final static UUID userId = UUID.fromString("743f885c-d740-11e9-8a34-2a2ae2dbcce4");
    private final static UUID userId2 = UUID.fromString("e2ea2580-c446-4f04-bd76-d7ddedbd4ed9");

    @PostConstruct
    public void insertEntities() {
        userRepo.save(
                new User(userId, "https://randomuser.me/api/portraits/women/39.jpg")
        );userRepo.save(
                new User(userId2, "https://randomuser.me/api/portraits/women/50.jpg")
        );
        userCardRepo.save(new UserCard(
                new UserCardId(userId, UUID.fromString("e06f64c7-cc15-486b-ba3b-bd90cc31dbcb")),
                "123",
                "Карточка Кенни",
                LocalDate.now(),
                550000.50,
                FundType.RUB
        ));
        userCardRepo.save(new UserCard(
                new UserCardId(userId, UUID.fromString("aee85a4a-403b-4769-9090-cb0c1273966f")),
                "321",
                "Карточка Пети",
                LocalDate.now(),
                1232.15,
                FundType.USD
        ));

        transactionRepo.save(new CardTransaction(
                new CardTransactionId(UUID.fromString("aee85a4a-403b-4769-9090-cb0c1273966f"), UUID.fromString("96033e20-b05d-11b7-8080-808080808080")),
                100d,
                TransactionStatusEnum.FINISHED,
                LocalDate.now(),
                LocalDateTime.now(),
                "OMG RLY",
                "Pupkin P.",
                UUID.fromString("c1ae11bd-1abc-4bcb-8697-d950e3bd6ef0"),
                "for food"
        ));

        transactionRepo.save(new CardTransaction(
                new CardTransactionId(UUID.fromString("aee85a4a-403b-4769-9090-cb0c1273966f"), UUID.fromString("2c89e2a0-d745-11e9-8080-808080808080")),
                200d,
                TransactionStatusEnum.IN_PROGRESS,
                LocalDate.now(),
                LocalDateTime.now(),
                "nice",
                "Vasilij P.",
                UUID.fromString("fd6b2d77-6d38-4265-9ca2-56c93c165c8b"),
                "for food2"
        ));



        recommendationRepo.save(
                new Recommendation(
                        new RecommendationId(
                                userId,
                                userId2,
                                UUID.fromString("df9e9cb0-8ec7-1776-8080-808080808080")
                        ),
                        "Petya",
                        "описываю",
                        "комментирую",
                        Sets.newHashSet("тыц", "тыцтыц")
                )
        );

        recommendationRepo.save(
                new Recommendation(
                        new RecommendationId(
                                userId,
                                userId2,
                                UUID.fromString("0adddeb0-876c-1b5e-8080-808080808080")
                        ),
                        "Petya2",
                        "описываю2",
                        "комментирую2",
                        Sets.newHashSet("тыц2", "тыцтыц2")
                )
        );

    }
}
