import java.util.Random;

public class Zombie extends Personaje{

    public Zombie() {
        Random rand = new Random();
        this.vidaMax = rand.nextInt(2) + 2; //añadir num habitacion - 1
        this.ptsVida = vidaMax;
        this.ptsAtaque = rand.nextInt(2) + 2; // añadir num habitacion - 1
    }

    @Override
    public int atacar() {
        Random rand = new Random();
        return rand.nextInt(ptsAtaque) + 1;
    }
}
