package javahack.raif.borsch.service.init.data;

import com.datastax.driver.core.utils.UUIDs;
import javahack.raif.borsch.domain.CardTransaction;
import javahack.raif.borsch.domain.CollaborationRequest;
import javahack.raif.borsch.domain.ids.CardTransactionId;
import javahack.raif.borsch.domain.ids.CollaborationRequestId;
import javahack.raif.borsch.enums.CollaborationRequestStatus;
import javahack.raif.borsch.enums.CollaborationRequestType;
import javahack.raif.borsch.enums.TransactionStatusEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static javahack.raif.borsch.service.init.DbDmInitService.USER_ID;
import static javahack.raif.borsch.service.init.DbDmInitService.USER_NAME;
import static javahack.raif.borsch.service.init.data.UserDataGenerator.USERS;

/**
 * Класс с генерируемыми на старте приложения данными по "Запрос на сотрудничество".
 *
 * @author denrus
 * 14.09.2019
 */
public class RequestDataGenerator {
    public static List<CollaborationRequest> REQUESTS = Arrays.asList(
        new CollaborationRequest(
            new CollaborationRequestId(
                USER_ID,
                USERS.get(2).getId(),
                UUID.randomUUID()
            ),
            LocalDate.of(2019, 9, 14),
            "Давайте сотрудничать",
            USER_NAME,
            USERS.get(2).getName(),
            CollaborationRequestStatus.PENDING,
            CollaborationRequestType.IN

        ),
        new CollaborationRequest(
            new CollaborationRequestId(
                USER_ID,
                USERS.get(3).getId(),
                UUID.randomUUID()
            ),
            LocalDate.of(2019, 9, 13),
            "Не хотите посотрудничать?",
            USER_NAME,
            USERS.get(3).getName(),
            CollaborationRequestStatus.PENDING,
            CollaborationRequestType.IN

        )
    );
}
