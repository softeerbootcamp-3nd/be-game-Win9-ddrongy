package softeer.hyundai.utils;

import java.util.Scanner;

public class GameManager {
    public static Scanner sc = new Scanner(System.in);
    public static boolean gameState = true;

    public static boolean isContinue() {
        return gameState;
    }
}
