public abstract class Personaje {
    protected int vidaMax;
    protected int ptsVida;
    protected int ptsAtaque;

    public abstract int atacar();

    public int getPtsVida() {
        return ptsVida;
    }

    public void setPtsVida(int ptsVida) {
        this.ptsVida = ptsVida;
    }

    public int getPtsAtaque() {
        return ptsAtaque;
    }

    public void setPtsAtaque(int ptsAtaque) {
        this.ptsAtaque = ptsAtaque;
    }
}
