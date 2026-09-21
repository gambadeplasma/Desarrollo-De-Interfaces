import java.util.Random;

public class Superviviente extends Personaje {

    private int armas;
    private int protecciones;
    private boolean botiquin;

    public Superviviente() {
        this.vidaMax = 20;
        this.ptsVida = 20;
        this.ptsAtaque = 4;
        this.armas = 0;
        this.protecciones = 0;
        this.botiquin = false;
    }

    @Override
    public int atacar() {
        Random rand = new Random();
        return rand.nextInt(ptsAtaque + armas) + 1;
    }

    public void curar() {
        setBotiquin(false);
        setPtsVida(Math.min(getPtsVida() + 4, vidaMax));
    }

    public void setBotiquin(boolean botiquin) {
        this.botiquin = botiquin;
    }

    public boolean tieneBotiquin() {
        return botiquin;
    }

    public void sumaProteccion() {
        protecciones++;
    }

    public void sumaArma() {
        armas++;
    }
}
