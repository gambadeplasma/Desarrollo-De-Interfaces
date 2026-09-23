import java.util.Random;

public class Habitacion {

    private int maxHabitaciones;
    private int numHabitacion;
    private int intentosBusqueda;
    private int numZombies;
    private final Zombie zombie;
    private final Superviviente superviviente;


    public Habitacion(int dificultad) {
        this.maxHabitaciones = 5 * dificultad;
        this.numHabitacion = 1;
        this.intentosBusqueda = 3;
        this.numZombies = 1;
        this.zombie = nuevoZombie();
        this.superviviente = new Superviviente();
    }

    private Zombie nuevoZombie() {
        numZombies++;
        return new Zombie();
    }

    public void resultadoBusqueda(int result) {

        if (result <= 75) {
            int ruido = hacerRuido();

            if(ruido <= 40) {
                System.out.println("No ha pasado nada...");
            } else if(ruido <= 80) {
                System.out.println("Aparece un zombie.");
                nuevoZombie();
            } else {
                System.out.println("Aparecen dos zombies.");
                nuevoZombie();
                nuevoZombie();
            }

        } else if (result <= 90) {

            if (superviviente.tieneBotiquin()) {
                System.out.println("Ya tienes un botiquín.");
            } else {
                System.out.println("Has encontrado un botiquín.");
                superviviente.setBotiquin(true);
            }

        } else if (result <= 95) {

            System.out.println("Has encontrado una protección.");
            superviviente.sumaProteccion();

        } else {

            System.out.println("Has encontrado un arma.");
            superviviente.sumaArma();
        }

    }

    public int hacerRuido() {

        Random rand = new Random();

        return rand.nextInt(100) + 1;
    }

    public void combate() {

        int turno = 1;

        while(zombie.getPtsVida() > 0 || superviviente.getPtsVida() > 0) {

            int ataqueJugador = superviviente.getPtsAtaque();
            int ataqueZombie = zombie.getPtsAtaque();

            System.out.println("<<TURNO " + turno + ">>");

            zombie.setPtsVida(zombie.getPtsVida() - ataqueJugador);
            System.out.println("El zombie recibe " + ataqueJugador + " puntos de daño.");

            if (zombie.getPtsVida() > 0) {

                superviviente.setPtsVida(superviviente.getPtsVida() - ataqueZombie);
                System.out.println("Recibes " + ataqueZombie + " puntos de daño.");
                turno++;

            } else {
                System.out.println("El zombie ha sido derrotado en el turno " + turno + ".");
                numZombies--;
            }

            if (superviviente.getPtsVida() <= 0) {
                System.out.println("GAME OVER.");
            }
        }
    }

    public void avanzarHabitacion() {

        numHabitacion++;
        intentosBusqueda = 3;
        nuevoZombie();
    }

    public void curarse() {
        superviviente.curar();
    }

    public int getNumZombies() {
        return numZombies;
    }

    public Superviviente getSuperviviente() {
        return superviviente;
    }

    public Zombie getZombie() {
        return zombie;
    }

    public int getIntentosBusqueda() {
        return intentosBusqueda;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public int getMaxHabitaciones() {
        return maxHabitaciones;
    }
}
