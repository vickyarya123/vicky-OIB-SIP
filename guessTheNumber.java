import java.util.Random;
import java.util.Scanner;

public class guessTheNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int rounds = 3;                 // number of rounds
        int maxAttempts = 5;            // attempts allowed per round
        int totalScore = 0;             // player total score

        System.out.println("🎮 Welcome to Guess The Number Game!");
        System.out.println("--------------------------------------");
        System.out.println("You will play " + rounds + " rounds.");
        System.out.println("You get " + maxAttempts + " attempts each round.");
        System.out.println("Points = (6 - attempts used) × 10\n");

        for (int round = 1; round <= rounds; round++) {

            int number = rand.nextInt(100) + 1;  // random number 1–100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("🔵 Round " + round + ": Guess a number between 1 and 100");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
                    int points = (6 - attempts) * 10; // fewer attempts = more points
                    totalScore += points;
                    System.out.println("You earned " + points + " points.\n");
                    guessedCorrectly = true;
                    break;
                }
                else if (guess < number) {
                    System.out.println("⬆ The number is HIGHER than " + guess);
                }
                else {
                    System.out.println("⬇ The number is LOWER than " + guess);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The correct number was: " + number + "\n");
            }
        }

        System.out.println("🏁 Game Over!");
        System.out.println("⭐ Your Total Score = " + totalScore + " points");
        System.out.println("--------------------------------------");
        System.out.println("Thanks for playing! 🎮");
        
        sc.close();
    }
}
