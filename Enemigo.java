public class Enemigo extends Personaje
{
    //Atributos

    int experienciaSoltada;
    int puntuacionSoltadaRanking;

    //Contructores

    public Enemigo(String nombre, int vidaMax, int vidaActual, int ataqueMin, int ataqueMax, int experienciaSoltada, int puntuacionSoltadaRanking)
    {
        super(nombre, vidaMax, vidaActual, ataqueMin, ataqueMax);
        this.experienciaSoltada = experienciaSoltada;
        this.puntuacionSoltadaRanking = puntuacionSoltadaRanking;
    }

    //Métodos

    @Override 
    public void mostrarDatos()
    {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Vida Máxima: " + getVidaMax());
        System.out.println("Vida Actual: " + getVidaActual());
        System.out.println("Daño mínimo: " + getAtaqueMin());
        System.out.println("Daño máximo: " + getAtaqueMax());
        System.out.println("Experiencia soltada: " + experienciaSoltada);
        System.out.println("Puntuación soltada para el ranking: " + puntuacionSoltadaRanking);
    }

    //Getters y Setters

    public int getExperienciaSoltada() {
        return experienciaSoltada;
    }

    public void setExperienciaSoltada(int experienciaSoltada) {
        this.experienciaSoltada = experienciaSoltada;
    }

    public int getPuntuacionSoltadaRanking() {
        return puntuacionSoltadaRanking;
    }

    public void setPuntuacionSoltadaRanking(int puntuacionSoltadaRanking) {
        this.puntuacionSoltadaRanking = puntuacionSoltadaRanking;
    }
}
