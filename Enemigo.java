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

    //Mostrar los datos

    public static void main(String[] args)
    {

        Enemigo Nevron = new Enemigo ("Nevron", 70, 70, 10, 15, 30, 100);
        Enemigo NevronVolador = new Enemigo ("Nevron Volador", 50, 50, 15, 20, 40, 100);
        Enemigo Petank = new Enemigo ("Petank", 200, 200, 5, 10, 150, 100);

        System.out.println("---------------------------");
        Nevron.mostrarDatos();
        System.out.println("---------------------------");
        NevronVolador.mostrarDatos();
        System.out.println("---------------------------");
        Petank.mostrarDatos();
        System.out.println("---------------------------");
    }
}
