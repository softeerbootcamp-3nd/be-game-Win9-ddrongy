package softeer.hyundai.controller;

import softeer.hyundai.domain.CardDummy;
import softeer.hyundai.domain.Dealer;
import softeer.hyundai.domain.Player;
import softeer.hyundai.utils.GameManager;

import static softeer.hyundai.utils.GameManager.gameState;
import static softeer.hyundai.utils.GameManager.sc;

public class GameController {
    private Player player = new Player();
    private Dealer dealer = new Dealer();

    private CardDummy cardDummy = new CardDummy();

    public void init() {
        System.out.println("Batting your money");
        try {
            player.batMoney(Integer.parseInt(sc.nextLine()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println(player.getBattingMoney() + "입니다.");
        cardDummy.initializeCards();

        System.out.println("--");
        player.addCard(cardDummy.drawCard());
        player.addCard(cardDummy.drawCard());

        dealer.addCard(cardDummy.drawCard());
        dealer.addHiddenCard(cardDummy.drawCard());
    }

    public void play() {
        showCard();
        while (GameManager.isContinue()) {
            System.out.println("Choose Option");
            int optionNumber = sc.nextInt();

            if (optionNumber == 1) {
                gameState = false;
                showHiddenCard();
            } else if (optionNumber == 2) {
                player.addCard(cardDummy.drawCard());
                drawDealerCard();
            } else if (optionNumber == 3) {
                player.doubleDown();
                player.addCard(cardDummy.drawCard());
                gameState = false;
            } else if (optionNumber == 4) {
                player.surrender();
                gameState = false;
            }

            showCard();


            if (isBlackJack() || isDead()) {
                gameState = false;
                showHiddenCard();
            }
        }
    }

    private void showHiddenCard() {
        System.out.println("Hidden: " + dealer.getHiddenCard());
    }

    private void showCard() {
        System.out.println("=== playerCard === ");
        player.showMyCards();
        System.out.println("=== dealerCard === ");
        dealer.showMyCards();
    }

    public void calculatePrize() {
        System.out.println("== Result == ");
        System.out.print(player.getBattingMoney());
        if (dealer.getScore() > 21 && player.getScore() < 21) {
            player.doubleDown();
        }
        if (dealer.getScore() < 21 && player.getScore() > 21) {
            player.lose();
        }

        if (dealer.getScore() > player.getScore()) {
            player.lose();
        }

        if (dealer.getScore() < player.getScore()) {
            player.doubleDown();
        }
        System.out.print(" -> ");
        System.out.println(player.getBattingMoney());
    }

    private boolean isBlackJack() {
        return dealer.getScore() == 21 || player.getScore() == 21;
    }

    private boolean isDead() {
        return player.getScore() > 21 || dealer.getScore() > 21;
    }

    private void drawDealerCard() {
        if (dealer.getScore() <= 16) {
            dealer.addCard(cardDummy.drawCard());
        }
    }

}
