public class Protagonista extends Personaje
{

    //Contructores

    public Protagonista(String nombre, int vidaMax, int vidaActual, int ataqueMin, int ataqueMax)
    {
        super(nombre, vidaMax, vidaActual, ataqueMin, ataqueMax);
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
    }

    //Mostrar los datos

    public static void main(String[] args)
    {

        Protagonista Gustave = new Protagonista ("Gustave", 100, 100, 10, 20);

        System.out.println("---------------------------");
        Gustave.mostrarDatos();
        System.out.println("---------------------------");
    }
}