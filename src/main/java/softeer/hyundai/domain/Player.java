package softeer.hyundai.domain;

import softeer.hyundai.utils.GameManager;

import java.util.ArrayList;
import java.util.List;

import static softeer.hyundai.utils.GameManager.sc;

public class Player {
    private int battingMoney;
    private List<Card> cardList = new ArrayList<>();

    public void batMoney(int battingMoney) throws IllegalAccessException {
        if (battingMoney <= 0) {
            throw new IllegalAccessException("금액 입력 오류");
        }
        this.battingMoney = battingMoney;
    }

    public void addCard(Card card) {
        if (card.getCardType().equals("A")){
            int cardScore = askAScore();
            card.setScore(cardScore);
        }
        cardList.add(card);
    }

    private int askAScore() {
        System.out.println("Choose 1 or 11");
        return sc.nextInt();
    }

    public int getScore() {
        return cardList.stream().mapToInt(Card::getScore).sum();
    }

    public void doubleDown() {
        battingMoney *= 2;
    }

    public void surrender() {
        battingMoney /= 2;
    }

    public int getBattingMoney() {
        return battingMoney;
    }

    public void lose() {
        this.battingMoney = 0;
    }

    public void showMyCards() {
        for (Card card : cardList) {
            System.out.print(card.getCardType() + " ");
        }
        System.out.println();
    }
}
