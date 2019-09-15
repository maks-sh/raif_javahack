package javahack.raif.borsch.service.init.data;

import com.datastax.driver.core.utils.UUIDs;
import com.google.common.collect.Sets;
import javahack.raif.borsch.domain.Recommendation;
import javahack.raif.borsch.domain.ids.RecommendationId;

import java.util.Arrays;
import java.util.List;

import static javahack.raif.borsch.service.init.DbDmInitService.USER_ID;
import static javahack.raif.borsch.service.init.data.UserDataGenerator.USERS;

/**
 * Класс с генерируемыми на старте приложения данными по рекоммендациям.
 *
 * @author denrus
 * 15.09.2019
 */
public class RecommendationsDataGenerator {
    public static List<Recommendation> RECOMMENDATIONS = Arrays.asList(
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(0).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(0).getName(),
            "Курьерская деятельность",
            "",
            USERS.get(0).getUrl(),
            Sets.newHashSet("Курьер", "Доставка")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(1).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(1).getName(),
            "Продажа овощей и фруктов",
            "",
            USERS.get(1).getUrl(),
            Sets.newHashSet("Ягоды", "Яблоки")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(2).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(2).getName(),
            "Удаленный бухгалтер",
            "",
            USERS.get(2).getUrl(),
            Sets.newHashSet("Реклама", "Бухгалетрия")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(3).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(3).getName(),
            "Образовательная деятельность",
            "",
            USERS.get(3).getUrl(),
            Sets.newHashSet("Реклама", "Обучения")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(4).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(4).getName(),
            "Кондитерские изделия",
            "",
            USERS.get(4).getUrl(),
            Sets.newHashSet("Конфеты", "Пирожные")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(5).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(5).getName(),
            "Продажа овощей и фруктов",
            "",
            USERS.get(5).getUrl(),
            Sets.newHashSet("Ягоды", "Помидоры")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(6).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(6).getName(),
            "Курьерская деятельность",
            "",
            USERS.get(6).getUrl(),
            Sets.newHashSet("Доставка", "Перевозка")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(7).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(7).getName(),
            "Продажа овощей и фруктов",
            "",
            USERS.get(7).getUrl(),
            Sets.newHashSet("Ягоды", "Черника")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(8).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(8).getName(),
            "Кондитерские изделия",
            "",
            USERS.get(8).getUrl(),
            Sets.newHashSet("Красители пищевые")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(9).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(9).getName(),
            "Курьерская деятельность",
            "",
            USERS.get(9).getUrl(),
            Sets.newHashSet("Перевозки", "Доставка")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(10).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(10).getName(),
            "Образовательная деятельность",
            "",
            USERS.get(10).getUrl(),
            Sets.newHashSet("Excel", "Маркетинг")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(11).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(11).getName(),
            "Продажа овощей и фруктов",
            "",
            USERS.get(11).getUrl(),
            Sets.newHashSet("Малина", "Черника")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(12).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(12).getName(),
            "Кондитерские изделия",
            "",
            USERS.get(12).getUrl(),
            Sets.newHashSet("Конфеты", "Пирожные")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(13).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(13).getName(),
            "Продажа овощей и фруктов",
            "",
            USERS.get(13).getUrl(),
            Sets.newHashSet("Яблоки", "Овощи")
        ),
        new Recommendation(
            new RecommendationId(
                USER_ID,
                USERS.get(14).getId(),
                UUIDs.timeBased()
            ),
            USERS.get(14).getName(),
            "Удаленный бухгалтер",
            "",
            USERS.get(14).getUrl(),
            Sets.newHashSet("Бухгалтерия")
        )
    );
}
