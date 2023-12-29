package softeer.hyundai.controller;

import softeer.hyundai.domain.CardDummy;
import softeer.hyundai.domain.Dealer;
import softeer.hyundai.domain.Player;

import java.io.Console;
import java.util.Scanner;

public class GameController {
    private Scanner sc = new Scanner(System.in);
    private Player player = new Player();
    private Dealer dealer = new Dealer();

    private CardDummy cardDummy = new CardDummy();

    public void init() throws IllegalAccessException {
        player.batMoney(sc.nextInt());
        cardDummy.initializeCards();

        player.addCard(cardDummy.drawCard());
        player.addCard(cardDummy.drawCard());

        dealer.addCard(cardDummy.drawCard());
        dealer.addHiddenCard(cardDummy.drawCard());
    }

}
