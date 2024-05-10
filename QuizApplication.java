import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int TIME_LIMIT_SECONDS = 60; // Time limit for the quiz in seconds
    private static int score = 0;
    private static Timer timer;

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        System.out.println("Welcome to the Quiz! You have " + TIME_LIMIT_SECONDS + " seconds to answer.");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("\nTime's up!");
                displayResult();
                System.exit(0);
            }
        }, TIME_LIMIT_SECONDS * 1000);

        // Question 1
        System.out.println("Question 1: What is the capital of France?");
        System.out.println("a) London");
        System.out.println("b) Paris");
        System.out.println("c) Rome");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("b")) {
            score++;
        }

        // Question 2
        System.out.println("Question 2: What is 2 + 2?");
        System.out.println("a) 3");
        System.out.println("b) 4");
        System.out.println("c) 5");
        answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("b")) {
            score++;
        }

        // Add more questions as needed...

        displayResult();
    }

    private static void displayResult() {
        timer.cancel(); // Stop the timer
        System.out.println("\nQuiz finished!");
        System.out.println("Your score is: " + score);
    }
}