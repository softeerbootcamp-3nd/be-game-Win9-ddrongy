package softeer.hyundai.domain;

import java.util.List;

public class Player {
    private int battingMoney;
    private List<Card> cardList;

    public void batMoney(int battingMoney) throws IllegalAccessException {
        if (battingMoney <= 0) {
            throw new IllegalAccessException("금액 입력 오류");
        }
        this.battingMoney = battingMoney;
    }

    public void addCard(Card card) {
        cardList.add(card);
    }
}
