import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 3; // Maximum number of attempts per round
        int numberOfRounds = 3; // Total number of rounds
        int score = 0; // set initial score to 0

        System.out.println("Welcome to the Guess the Number game! Let's start.");

        for (int round = 1; round <= numberOfRounds; round++) {
            int randomNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100
            System.out.println("\nRound " + round + ":");
            boolean hasGuessedCorrectly = false;

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess between 1 and 100 (1-100): ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! What a guess! You guessed the number correctly.");
                    hasGuessedCorrectly = true;
                    score += (maxAttempts - attempt + 1); // Give points based on the number of attempts left
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("The number is higher than " + userGuess + " , please try again");
                } else {
                    System.out.println("The number is lower than " + userGuess + " , please try again");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry! You've reached the max attempts. The correct number was " + randomNumber + ".");
            }
        }

        System.out.println("\nGame Over! Your total score is: " + score);
        scanner.close();
    }
}
