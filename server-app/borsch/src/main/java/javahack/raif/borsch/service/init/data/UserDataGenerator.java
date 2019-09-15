package javahack.raif.borsch.service.init.data;

import javahack.raif.borsch.domain.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Класс с генерируемыми на старте приложения данными по пользователям.
 *
 * @author denrus
 * 15.09.2019
 */
@Service
public class UserDataGenerator {
    public static List<User> USERS = Arrays.asList(
        new User(
            UUID.randomUUID(),
            "https://sun9-69.userapi.com/c638316/v638316828/36ccf/XTc9ni64z4k.jpg?ava=1",
            "ИП Берсенян Витя Аскерович"
        ),
        new User(
            UUID.randomUUID(),
            "https://sun9-16.userapi.com/c637718/v637718788/20f7d/lIOkCHIcpKU.jpg?ava=1",
            "ИП Хомченко Григорий Витальевич"
        ),
        new User(
            UUID.randomUUID(),
            "https://sun9-43.userapi.com/c850636/v850636301/16866e/m8toVEJ-OSg.jpg?ava=1",
            "ООО БухФинанс"
        ),
        new User(
            UUID.randomUUID(),
            "https://sun9-62.userapi.com/c850616/v850616623/15d5c1/WCeH3alm-ts.jpg?ava=1",
            "ИП Ермолаев Петр Константинович"
        ),
        new User(
            UUID.randomUUID(),
            "https://sun9-45.userapi.com/c627529/v627529749/a9cf/0J1dt21LcTo.jpg?ava=1",
            "ООО Пирожок-1"
        ),
        new User(
            UUID.randomUUID(),
            "https://sun9-17.userapi.com/c624231/v624231805/48e67/YML7MqflL64.jpg?ava=1",
            "ИП Цыпяева Виктория Сергеевна"
        ),
        new User(
            UUID.randomUUID(),
            "https://sun9-34.userapi.com/c836731/v836731806/297df/cYQw-6O8u6Q.jpg?ava=1",
            "ООО Грузовичковский"
        ),
        new User(
            UUID.randomUUID(),
            "https://pp.userapi.com/N7x7tHY6-OJjY0eKJZ9hg_indE9obfe3TUdEdQ/BFD5VRH724Q.jpg?ava=1",
            "ООО Цветовой Сад"
        ),
        new User(
            UUID.randomUUID(),
            "https://sun9-23.userapi.com/c855028/v855028111/42f01/n7ZJIQVCoYw.jpg?ava=1",
            "ИП Шматаева Валентина Никитична"
        ),
        new User(
            UUID.randomUUID(),
            "https://sun9-40.userapi.com/c10867/u173554907/a_18837f33.jpg?ava=1",
            "ИП Киселев Иван Денисович"
        ),
        new User(
            UUID.randomUUID(),
            "https://sun1-15.userapi.com/c837528/v837528271/75dd6/Oi0HnV0ogO0.jpg?ava=1",
            "ИП Акропишин Евгений Витальевич"
        ),
        new User(
            UUID.randomUUID(),
            "https://sun9-13.userapi.com/c844723/v844723820/1b8979/T69UvkF_jrA.jpg?ava=1",
            "ООО Кавказский Пленник"
        ),
        new User(
            UUID.randomUUID(),
            "https://sun9-37.userapi.com/c844721/v844721002/d3abd/egT_JLkRUtY.jpg?ava=1",
            "ИП Черпачкова Галина Витальевна"
        ),
        new User(
            UUID.randomUUID(),
            "https://pp.userapi.com/NycHx2JvnivVgSopyqvt2ADu7YVSyPZHiA8KYQ/JmGMevTpV0k.jpg?ava=1",
            "ИП Крапиева Ольга Петровна"
        ),
        new User(
            UUID.randomUUID(),
            "https://sun9-33.userapi.com/c830709/v830709062/71b8d/yh7KTpz-UnE.jpg?ava=1",
            "ИП Кравцова Ангелина Николаевна"
        )

    );
}
