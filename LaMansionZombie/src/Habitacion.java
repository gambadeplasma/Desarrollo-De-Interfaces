import java.util.Random;

public class Habitacion {

    private int maxHabitaciones;
    private int numHabitacion;
    private int intentosBusqueda;
    private int numZombies;
    private Zombie ayusoAsesina;


    public Habitacion(int opDificultad) {
        this.maxHabitaciones = 5 * opDificultad;
        this.numHabitacion = 1;
        this.intentosBusqueda = 3;
        this.numZombies = 1;
        this.ayusoAsesina = nuevoZombie();
    }

    private Zombie nuevoZombie() {
        numZombies++;
        return new Zombie();
    }

    public void resultBusqueda(int result) {

        if (result <= 75) {
            int ruido = hacerRuido();
        } else if (result <= 90) {

        } else if (result <= 95) {

        } else {

        }

    }

    public int hacerRuido() {
        return 1;
    }
}
