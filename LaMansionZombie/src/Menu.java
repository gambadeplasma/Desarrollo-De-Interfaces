import java.util.Scanner;

public class Menu {

    private Habitacion habitacion;

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

    public void llamaCombate() {
        habitacion.combate();
    }

    public void llamaCuracion() {
        habitacion.curarse();
    }

    public void llamaBuscar() {
        habitacion.resultadoBusqueda(habitacion.hacerRuido());
    }

    public void llamaAvanzar() {
        habitacion.avanzarHabitacion();
    }

    public void opciones() {
        if (habitacion.getNumZombies() != 0) {
            System.out.println("1. Combatir");

        } else {

            if (habitacion.getIntentosBusqueda() != 0) {
                System.out.println("2. Buscar");
            }

            if (habitacion.getSuperviviente().tieneBotiquin()) {
                System.out.println("3. Curarse");
            }

            if (habitacion.getNumHabitacion() < habitacion.getMaxHabitaciones()) {
                System.out.println("4. Avanzar");

            } else {
                System.out.println("4. Salir de la mansión.");
            }
        }
    }
}
