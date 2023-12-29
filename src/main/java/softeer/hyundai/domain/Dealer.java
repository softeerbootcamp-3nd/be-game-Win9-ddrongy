package softeer.hyundai.domain;

import java.util.List;

public class Dealer {
    private List<Card> cardList;
    private Card hiddenCard;

    public void addCard(Card card) {
        cardList.add(card);
    }

    public void addHiddenCard(Card card) {
        this.hiddenCard = hiddenCard;
    }

    public int getScore() {
        return cardList.stream().mapToInt(Card::getScore).sum() + hiddenCard.getScore();
    }
}
