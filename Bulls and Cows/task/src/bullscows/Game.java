package bullscows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final List<String> allSymbolsList = new ArrayList<>();
    private final List<String> acceptableSymbolsList = new ArrayList<>();
    private final StringBuilder secretCode = new StringBuilder();
    private final Scanner scanner = new Scanner(System.in);
    private int definedCodeLength;
    private int acceptableSymbolsNumber;
    private int bulls = 0;
    private int turns = 0;

    private void fillList() {
        for (int i = 0; i < 10; i++) {
            allSymbolsList.add(String.valueOf(i));
        }
        for (char c = 97; c <= 122; c++) {
            allSymbolsList.add(String.valueOf(c));
        }
    }

    private void generateSecretCode() {
        Random random = new Random();
        int acceptableSymbolsListLength = acceptableSymbolsNumber;
        for (int i = 0; i < acceptableSymbolsListLength; i++) {
            acceptableSymbolsList.add(allSymbolsList.get(i));
        }
        while (secretCode.length() < definedCodeLength) {
            int i = random.nextInt(acceptableSymbolsListLength);
            secretCode.append(acceptableSymbolsList.get(i));
            acceptableSymbolsList.remove(i);
            acceptableSymbolsListLength--;
        }
    }

    private void prepareGame() {
        System.out.println("Input the length of the secret code:");
        checkCodeLengthInputForValidity();
        fillList();
        System.out.println("Input the number of possible symbols in the code:");
        checkSymbolsNumberInputForValidity();
        generateSecretCode();
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < definedCodeLength; i++) {
            System.out.print('*');
        }
        System.out.print(" ");
        if (acceptableSymbolsNumber < 11) {
            System.out.println("(0-9).");
        } else if (acceptableSymbolsNumber == 11) {
            System.out.println("(0-9, a).");
        } else {
            System.out.println("(0-9, a-" + allSymbolsList.get(acceptableSymbolsNumber - 1) + ").");
        }
        System.out.println("Okay, let's start a game!");
    }

    private void runGame() {
        while (!(bulls == definedCodeLength)) {
            bulls = 0;
            int cows = 0;
            turns++;
            System.out.println("Turn " + turns + ":");
            String userGuessCode = scanner.next();
            for (int i = 0; i < secretCode.length(); i++) {
                if (userGuessCode.charAt(i) == secretCode.charAt(i)) {
                    bulls++;
                } else {
                    for (int j = 0; j < secretCode.length(); j++) {
                        if (j == i) {
                            continue;
                        }
                        if (userGuessCode.charAt(j) == secretCode.charAt(i)) {
                            cows++;
                        }
                    }
                }
            }
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + "cow(s).");
        }
    }

    public void playGame() {
        prepareGame();
        runGame();
    }

    public void checkCodeLengthInputForValidity() {
        String definedCodeLengthString;
        if (scanner.hasNext("[0-9]*")) {
            definedCodeLengthString = scanner.next();
            definedCodeLength = Integer.parseInt(definedCodeLengthString);
        } else {
            definedCodeLengthString = scanner.nextLine();
            System.out.println("Error: " + definedCodeLengthString + " isn't a valid number.");
            System.exit(0);
        }
        if ("0".equals(definedCodeLengthString) || Integer.parseInt(definedCodeLengthString) > 36) {
            System.out.println("Error: The length of the secret code must be greater than 0 and less than 37");
            System.exit(0);
        }

    }

    public void checkSymbolsNumberInputForValidity() {
        acceptableSymbolsNumber = scanner.nextInt();
        if (acceptableSymbolsNumber < definedCodeLength) {
            System.out.println("Error: it's not possible to generate a code with a length of " + definedCodeLength +
                    " with " + acceptableSymbolsNumber + " unique symbols.");
            System.exit(0);
        }
        if (acceptableSymbolsNumber > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }
    }
}
