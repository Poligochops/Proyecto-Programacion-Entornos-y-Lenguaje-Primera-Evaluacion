public class Personaje
{
    //Atributos

    String nombre;
    int vidaMax;
    int vidaActual;
    int ataqueMin;
    int ataqueMax;

    //Contructores

    public Personaje(String nombre, int vidaMax, int vidaActual, int ataqueMin, int ataqueMax)
    {
        this.nombre = nombre;
        this.vidaMax = vidaMax;
        this.vidaActual = vidaActual;
        this.ataqueMin = ataqueMin;
        this.ataqueMax = ataqueMax;
    }

    //Métodos

    public void mostrarDatos()
    {
        System.out.println("Nombre: " + nombre);
        System.out.println("Vida Máxima: " + vidaMax);
        System.out.println("Vida Actual: " + vidaActual);
        System.out.println("Daño mínimo: " + ataqueMin);
        System.out.println("Daño máximo: " + ataqueMax);
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getAtaqueMin() {
        return ataqueMin;
    }

    public void setAtaqueMin(int ataqueMin) {
        this.ataqueMin = ataqueMin;
    }

    public int getAtaqueMax() {
        return ataqueMax;
    }

    public void setAtaqueMax(int ataqueMax) {
        this.ataqueMax = ataqueMax;
    }
}