package start;

import model.Computer;
import model.Player;
import services.GameService;

import java.util.Scanner;

public class Play {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Player player1 = new Player();
		Player player2 = new Player();
		int player1Wins = 0;
		int player2Wins = 0;
		boolean playAgainstComputer = true;

		System.out.println("¡¡¡Bienvenido al juego de Piedra, Papel, Tijeras, Lagarto, Spock!!!");
		System.out.println("Jugador 1, ingresa tu nombre:");
		player1.setName(scanner.nextLine());

		while (true) {
			System.out.println(
					"¿Quieres jugar contra la máquina o contra un amigo? (Pulsa --1-- para jugar contra la máquina. Pulsa --2-- para jugar contra tu amigo)");
			int opponentChoice = scanner.nextInt();
			scanner.nextLine();
			if (opponentChoice == 1) {
				playAgainstComputer = true;
				player2.setName("La máquina");
				break;
			} else if (opponentChoice == 2) {
				playAgainstComputer = false;
				System.out.println("Jugador 2, ingresa tu nombre:");
				player2.setName(scanner.nextLine());
				break;
			} else {
				System.out.println("Opción inválida. Inténtalo de nuevo.");
			}
		}

		while (player1Wins < 3 && player2Wins < 3) {
			int player1Choice;
			while (true) {
				System.out.println(player1.getName()
						+ ", elige una opción: \n1. Piedra ---> \u270A \n2. Papel ---> \u270B \n3. Tijeras ---> \u270C \n4. Lagarto ---> \uD83E\uDD8E \n5. Spock ---> \uD83D\uDD96");
				player1Choice = scanner.nextInt();
				if (player1Choice >= 1 && player1Choice <= 5) {
					break;
				} else {
					System.out.println("Número no válido. Inténtalo de nuevo.");
				}
			}

			int player2Choice;
			if (playAgainstComputer) {
				player2Choice = Computer.generateOption();
				System.out.println(player2.getName() + " eligió: " + GameService.getChoiceName(player2Choice));
			} else {
				while (true) {
					System.out.println(player2.getName()
							+ ", elige una opción: \n1. Piedra ---> \u270A \n2. Papel ---> \u270B \n3. Tijeras ---> \u270C \n4. Lagarto ---> \uD83E\uDD8E \n5. Spock ---> \uD83D\uDD96");
					player2Choice = scanner.nextInt();
					if (player2Choice >= 1 && player2Choice <= 5) {
						break;
					} else {
						System.out.println("Número no válido. Inténtalo de nuevo.");
					}
				}
			}

			String result = GameService.playGame(player1Choice, player2Choice);
			if (result.equals("Ganaste")) {
				System.out.println(player1.getName() + " ganó esta partida!!!");
				player1Wins++;
			} else if (result.equals("Perdiste")) {
				System.out.println(player2.getName() + " ganó esta partida!!!");
				player2Wins++;
			} else {
				System.out.println("¡Empate!");
			}
		}

		if (player1Wins == 3) {
			System.out.println(player1.getName() + " ganó el juego!");
		} else {
			System.out.println(player2.getName() + " ganó el juego!");
		}

		scanner.close();
	}
}
