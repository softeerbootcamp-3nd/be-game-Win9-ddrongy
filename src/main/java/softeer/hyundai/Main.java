package softeer.hyundai;

import softeer.hyundai.controller.GameController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        GameController gameController = new GameController();
        gameController.init();
        gameController.play();
        gameController.calculatePrize();
    }
}