package softeer.hyundai.domain;

public class Card {
    private String cardType;
    private int score;

    public Card(String cardType, int score) {
        this.cardType = cardType;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getCardType() {
        return cardType;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
