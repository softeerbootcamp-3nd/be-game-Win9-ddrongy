package softeer.hyundai.domain;

import java.util.ArrayList;
import java.util.List;

public class CardDummy {
    private List<Card> cardList;

    public void initializeCards() {
        List<String> cards = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J");

        for (int i = 0; i < 4; i++) {
            for (String cardValue : cards) {
                cardList.add(new Card(cardValue));
            }
        }

    }
}
