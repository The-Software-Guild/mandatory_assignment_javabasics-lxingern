import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	
	static int[][] matrix = {{0, 1, 2}, {2, 0, 1}, {1, 2, 0}};
	static String[] choices = {"Rock", "Paper", "Scissors"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rng = new Random();
		boolean gameOn = true;
		int rounds;
		int[] results;
		
		while (gameOn == true) {
			rounds = getNoOfRounds(sc);
			if (rounds == 0) return;
			
			results = runGame(rounds, sc, rng);
			
			determineWinner(results);
			
			gameOn = getGameOn(sc);
			
			System.out.println("");
		}

		System.out.println("Thanks for playing!");
		sc.close();
	}
	
	private static int getNoOfRounds(Scanner sc) {
		System.out.println("How many rounds would you like to play?");
		int rounds = Integer.parseInt(sc.nextLine());
		if (rounds > 10 || rounds < 1) {
			System.out.println("Input given is out of range! Minimum number of rounds is 1 and maximum is 10.");
			sc.close();
			return 0;
		}
		return rounds;
	}
	
	private static int[] runGame(int rounds, Scanner sc, Random rng) {
		int playerChoice, computerChoice, outcome;
		int[] results = new int[3];
		
		for (int i = 1; i <= rounds; i++) {
			System.out.println("\nRound " + i + ":");
			System.out.println("1: Rock, 2: Paper, or 3: Scissors?");
			
			playerChoice = Integer.parseInt(sc.nextLine()) - 1;
			computerChoice = rng.nextInt(3);
			System.out.println("You chose " + choices[playerChoice] + " and the computer chose " + choices[computerChoice] + ".");
			
			outcome = matrix[computerChoice][playerChoice];
			switch(outcome) {
			case 0: 
				System.out.println("It's a tie!");
				results[0]++;
				break;
			case 1:
				System.out.println("You win!");
				results[1]++;
				break;
			case 2:
				System.out.println("The computer wins!");
				results[2]++;
			}
		}
		
		return results;
	}
	
	private static void determineWinner(int[] results) {
		System.out.println("\nNumber of ties: " + results[0]);
		System.out.println("Number of player wins: " + results[1]);
		System.out.println("Number of computer wins: " + results[2]);
		if (results[1] > results[2]) {
			System.out.println("You won!!!");
		} else if (results[2] > results[1]) {
			System.out.println("The computer won. Try again next time!");
		} else {
			System.out.println("You tied with the computer!");
		}
	}
	
	private static boolean getGameOn(Scanner sc) {
		System.out.println("\nWould you like to play again? (Y/N)");
		String response = sc.nextLine();
		if (response.equals("N")) {
			return false;
		}
		return true;
	}
	
}
