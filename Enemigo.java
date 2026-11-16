public class Enemigo extends Personaje
{
    //Atributos

    int puntuacionSoltadaRanking;

    //Contructores

    public Enemigo(String nombre, int vidaMax, int vidaActual, int ataqueMin, int ataqueMax, int puntuacionSoltadaRanking)
    {
        super(nombre, vidaMax, vidaActual, ataqueMin, ataqueMax);
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
        System.out.println("Puntuación soltada para el ranking: " + puntuacionSoltadaRanking);
    }

    //Getters y Setters

    public int getPuntuacionSoltadaRanking() {
        return puntuacionSoltadaRanking;
    }

    public void setPuntuacionSoltadaRanking(int puntuacionSoltadaRanking) {
        this.puntuacionSoltadaRanking = puntuacionSoltadaRanking;
    }

    //Mostrar los datos

    public static void main(String[] args)
    {

        Enemigo Nevron = new Enemigo ("Nevron", 70, 70, 10, 15, 100);
        Enemigo NevronVolador = new Enemigo ("Nevron Volador", 50, 50, 15, 20, 100);
        Enemigo Petank = new Enemigo ("Petank", 200, 200, 8, 12, 100);

        System.out.println("---------------------------");
        Nevron.mostrarDatos();
        System.out.println("---------------------------");
        NevronVolador.mostrarDatos();
        System.out.println("---------------------------");
        Petank.mostrarDatos();
        System.out.println("---------------------------");
    }
}
