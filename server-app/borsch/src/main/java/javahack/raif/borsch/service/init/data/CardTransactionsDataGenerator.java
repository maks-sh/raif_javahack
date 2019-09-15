package javahack.raif.borsch.service.init.data;

import com.datastax.driver.core.utils.UUIDs;
import javahack.raif.borsch.domain.CardTransaction;
import javahack.raif.borsch.domain.ids.CardTransactionId;
import javahack.raif.borsch.enums.TransactionStatusEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Класс с генерируемыми на старте приложения данными по "Транзакциям карт".
 *
 * @author denrus
 * 14.09.2019
 */
public class CardTransactionsDataGenerator {
    public static List<CardTransaction> TRANSACTIONS = Arrays.asList(
        new CardTransaction(
            new CardTransactionId(UUID.fromString("aee85a4a-403b-4769-9090-cb0c1273966f"), UUIDs.timeBased()),
            929.76d,
            TransactionStatusEnum.FINISHED,
            LocalDate.of(2019, 9, 12),
            LocalDateTime.of(2019, 9, 12, 15, 45, 21),
            "",
            "ПАО \"МТС\"",
            UUID.randomUUID(),
            "Услуги связи за август 2019 г. В том числе НДС 20% - 185,95 руб."
        ),
        new CardTransaction(
            new CardTransactionId(UUID.fromString("aee85a4a-403b-4769-9090-cb0c1273966f"), UUIDs.timeBased()),
            10000d,
            TransactionStatusEnum.FINISHED,
            LocalDate.of(2019, 9, 13),
            LocalDateTime.of(2019, 9, 13, 16, 45, 21),
            "",
            "Жуковская Елена Викторовна",
            UUID.randomUUID(),
            "Перевод на личные нужды"
        ),
        new CardTransaction(
            new CardTransactionId(UUID.fromString("aee85a4a-403b-4769-9090-cb0c1273966f"), UUIDs.timeBased()),
            15238.34d,
            TransactionStatusEnum.FINISHED,
            LocalDate.of(2019, 9, 14),
            LocalDateTime.of(2019, 9, 14, 8, 7, 21),
            "",
            "ИФНС №17 ПО МО",
            UUID.randomUUID(),
            "Страховые взносы на обязательное пенсионное страхование в фиксированном размере с доходов свыше 300 т.р. за 2 квартал 2019 г. Без НДС"
        ),
        new CardTransaction(
            new CardTransactionId(UUID.fromString("aee85a4a-403b-4769-9090-cb0c1273966f"), UUIDs.timeBased()),
            30000d,
            TransactionStatusEnum.FINISHED,
            LocalDate.of(2019, 9, 14),
            LocalDateTime.of(2019, 9, 14, 8, 7, 21),
            "",
            "ООО \"Доморобус\"",
            UUID.randomUUID(),
            "Оплата аренды по договору № 02 от 18.01.2019 за октябрь 2019 г. НДС не облагается"
        ),
        new CardTransaction(
            new CardTransactionId(UUID.fromString("aee85a4a-403b-4769-9090-cb0c1273966f"), UUIDs.timeBased()),
            11082.65d,
            TransactionStatusEnum.FINISHED,
            LocalDate.of(2019, 9, 14),
            LocalDateTime.of(2019, 9, 14, 8, 7, 21),
            "",
            "ИП Богачева Светлана Геннадьевна",
            UUID.randomUUID(),
            "Оплата счета от 13.10.2019 за картонные упаковки для кондитерских изделий для Богачевой СГ. В том числе НДС  20% - 2216,5"
        ),
//        вторая карточка
        new CardTransaction(
            new CardTransactionId(UUID.fromString("e06f64c7-cc15-486b-ba3b-bd90cc31dbcb"), UUIDs.timeBased()),
            1077.67d,
            TransactionStatusEnum.FINISHED,
            LocalDate.of(2019, 8, 21),
            LocalDateTime.of(2019, 8, 21, 11, 21, 51),
            "",
            "Городская клиническая больница им. Семашко",
            UUID.randomUUID(),
            "Оплата по счету № 267 от 21.08.2019 за лечение и госпитализацию Жуковой Евгении. " +
                "НДС не облагается"
        ),
        new CardTransaction(
            new CardTransactionId(UUID.fromString("e06f64c7-cc15-486b-ba3b-bd90cc31dbcb"), UUIDs.timeBased()),
            4000d,
            TransactionStatusEnum.FINISHED,
            LocalDate.of(2019, 9, 11),
            LocalDateTime.of(2019, 9, 11, 21, 1, 9),
            "",
            "Жуков Петр Вальерьевич",
            UUID.randomUUID(),
            "Перечисление подотчетных средств на банковскую карту работника на основании заявления б/н " +
                "от 29.08.2019 в сумме 4000 руб на приобретение дополнительного оборудования. Без НДС"
        ),
        new CardTransaction(
            new CardTransactionId(UUID.fromString("e06f64c7-cc15-486b-ba3b-bd90cc31dbcb"), UUIDs.timeBased()),
            10000d,
            TransactionStatusEnum.FINISHED,
            LocalDate.of(2019, 9, 7),
            LocalDateTime.of(2019, 9, 7, 3, 53, 31),
            "",
            "ИП Бандитов Руслан",
            UUID.randomUUID(),
            "Оплата поставщику по счету 10 от 07.09.2019 за пищевой краситель. В т.ч. НДС 20%"
        )
    );
}
