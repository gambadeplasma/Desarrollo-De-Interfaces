import java.util.Random;

public class Habitacion {

    private int maxHabitaciones;
    private int numHabitacion;
    private int intentosBusqueda;
    private int numZombies;
    private Zombie ayusoAsesina;
    private Superviviente sanchezLadron;


    public Habitacion(int dificultad) {
        this.maxHabitaciones = 5 * dificultad;
        this.numHabitacion = 1;
        this.intentosBusqueda = 3;
        this.numZombies = 1;
        this.ayusoAsesina = nuevoZombie();
        this.sanchezLadron = new Superviviente();
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

            if (sanchezLadron.tieneBotiquin()) {
                System.out.println("Ya tienes un botiquín.");
            } else {
                System.out.println("Has encontrado un botiquín.");
                sanchezLadron.setBotiquin(true);
            }

        } else if (result <= 95) {

            System.out.println("Has encontrado una protección.");
            sanchezLadron.sumaProteccion();

        } else {

            System.out.println("Has encontrado un arma.");
            sanchezLadron.sumaArma();
        }

    }

    public int hacerRuido() {

        Random rand = new Random();

        return rand.nextInt(100) + 1;
    }

    public void combate() {

        int turno = 1;

        while(ayusoAsesina.getPtsVida() > 0 || sanchezLadron.getPtsVida() > 0) {

            int ataqueJugador = sanchezLadron.getPtsAtaque();
            int ataqueZombie = ayusoAsesina.getPtsAtaque();

            System.out.println("<<TURNO " + turno + ">>");

            ayusoAsesina.setPtsVida(ayusoAsesina.getPtsVida() - ataqueJugador);
            System.out.println("El zombie recibe " + ataqueJugador + " puntos de daño.");

            if (ayusoAsesina.getPtsVida() > 0) {

                sanchezLadron.setPtsVida(sanchezLadron.getPtsVida() - ataqueZombie);
                System.out.println("Recibes " + ataqueZombie + " puntos de daño.");
                turno++;

            } else {
                System.out.println("El zombie ha sido derrotado en el turno " + turno + ".");
                numZombies--;
            }

            if (sanchezLadron.getPtsVida() <= 0) {
                System.out.println("GAME OVER.");
            }
        }
    }

    public void avanzarHabitacion(int dificultad) {

        numHabitacion++;
        intentosBusqueda = 3;
        nuevoZombie();
    }

    public void curarse() {
        sanchezLadron.curar();
    }
}
