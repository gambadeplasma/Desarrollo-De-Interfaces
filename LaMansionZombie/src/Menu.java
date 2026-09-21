import java.util.Scanner;

public class Menu {

    public int elegirDificultad() {
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("Introduzca la dificultad en la que desea jugar: ");
            System.out.println("1. Fácil");
            System.out.println("2. Difícil");

            op = sc.nextInt();

        } while (op != 1 && op != 2);

        return op;
    }

    public void accion() {

    }


}
