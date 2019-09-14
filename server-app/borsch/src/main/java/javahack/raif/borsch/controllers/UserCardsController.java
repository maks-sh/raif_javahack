package javahack.raif.borsch.controllers;

import javahack.raif.borsch.dto.CardTransactionDto;
import javahack.raif.borsch.dto.UserCardDto;
import javahack.raif.borsch.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("user")
public class UserCardsController {

    @GetMapping("/{userId}")
    public String getUserInfo(
            @PathVariable("userId") String userId
    ) {
        UserDto user = new UserDto();
        //TODO getuser
        return user.toString();
    }

    @GetMapping("/card/{cardId}")
    public String getCardInfo(
            @PathVariable("cardId") String cardId
    ) {
        UserCardDto card = new UserCardDto();
        //TODO getuser
        return card.toString();
    }


    @GetMapping("/card/{cardId}/transactions")
    public String getCardTransactions(
            @PathVariable("cardId") String cardId
    ) {
        Set<CardTransactionDto> card = new UserCardDto().getTransactions();
        //TODO getCardTranaction
        return card.toString();
    }

}
