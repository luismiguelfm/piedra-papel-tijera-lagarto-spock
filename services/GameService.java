package services;

public class GameService {
    public static String playGame(int player1Option, int player2Option) {
        String result = "";
        if (player1Option == player2Option) {
            result = "Empate";
        } else if ((player1Option == 1 && (player2Option == 3 || player2Option == 4)) ||
                (player1Option == 2 && (player2Option == 1 || player2Option == 5)) ||
                (player1Option == 3 && (player2Option == 2 || player2Option == 4)) ||
                (player1Option == 4 && (player2Option == 2 || player2Option == 5)) ||
                (player1Option == 5 && (player2Option == 1 || player2Option == 3))) {
            result = "Ganaste";
        } else {
            result = "Perdiste";
        }
        return result;
    }

    public static String getChoiceName(int choice) {
        switch (choice) {
            case 1:
                return "Piedra " + emoji(choice);
            case 2:
                return "Papel " + emoji(choice);
            case 3:
                return "Tijeras " + emoji(choice);
            case 4:
                return "Lagarto " + emoji(choice);
            case 5:
                return "Spock " + emoji(choice);
            default:
                return "";
        }
    }

    public static String emoji(int num) {
        if (num==1) {
            return "\u270A";
        } else if (num==2) {
            return "\u270B";
        } else if (num==3) {
            return "\u270C";
        } else if (num==4) {
            return "\uD83E\uDD8E";
        } else if (num==5) {
            return "\uD83D\uDD96";
        } else {
            return "Opción no válida";
        }
    }
}
