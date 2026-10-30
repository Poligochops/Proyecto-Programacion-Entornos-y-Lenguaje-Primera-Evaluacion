public class Protagonista extends Personaje
{
    //Atributos

    int nivel;

    //Contructores

    public Protagonista(String nombre, int vidaMax, int vidaActual, int ataqueMin, int ataqueMax, int nivel)
    {
        super(nombre, vidaMax, vidaActual, ataqueMin, ataqueMax);
        this.nivel = nivel;
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
        System.out.println("Nivel: " + nivel);
    }

    //Getters y Setters

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}