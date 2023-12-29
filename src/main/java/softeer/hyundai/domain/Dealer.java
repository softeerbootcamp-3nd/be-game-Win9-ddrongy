package softeer.hyundai.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private List<Card> cardList = new ArrayList<>();
    private Card hiddenCard;

    public void addCard(Card card) {
        if (card.getCardType().equals("A") && getScore() <= 10) {
            card.setScore(11);
        }
        cardList.add(card);
    }

    public void addHiddenCard(Card card) {
        this.hiddenCard = card;
    }

    public int getScore() {
        return cardList.stream().mapToInt(Card::getScore).sum() + hiddenCard.getScore();
    }

    public void showMyCards() {
        for (Card card : cardList) {
            System.out.print(card.getCardType() + " ");
        }
        System.out.println();
    }}
