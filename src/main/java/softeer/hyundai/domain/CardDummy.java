package softeer.hyundai.domain;

import softeer.hyundai.utils.GameManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CardDummy {
    private List<Card> cardList = new ArrayList<>();

    public void initializeCards() {
        List<String> cards = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J");
        List<Integer> scores = List.of(1,2,3,4,5,6,7,8,9,10,10,10,10);
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < cards.size(); j++) {
                cardList.add(new Card(cards.get(j), scores.get(j)));
            }
        }
        Collections.shuffle(cardList);
    }

    public Card drawCard() {
        if (cardList.isEmpty()) {
            GameManager.gameState = false;
            return null;
        }
        return cardList.remove(0);
    }
}
