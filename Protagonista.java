public class Protagonista
{
    //Atributos

    String nombre;
    int vida;
    int dañoMin;
    int dañoMax;
    int nivel;

    //Contructores

    public Protagonista(String nombre, int vida, int dañoMin, int dañoMax, int nivel)
    {
        this.nombre = nombre;
        this.vida = vida;
        this.dañoMin = dañoMin;
        this.dañoMax = dañoMax;
        this.nivel = nivel;
    }

    //Métodos

    public void mostrarDatos()
    {
        System.out.println("Nombre: " + nombre);
        System.out.println("Vida: " + vida);
        System.out.println("Daño mínimo: " + dañoMin);
        System.out.println("Daño máximo: " + dañoMax);
        System.out.println("Nivel: " + nivel);
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDañoMin() {
        return dañoMin;
    }

    public void setDañoMin(int dañoMin) {
        this.dañoMin = dañoMin;
    }

    public int getDañoMax() {
        return dañoMax;
    }

    public void setDañoMax(int dañoMax) {
        this.dañoMax = dañoMax;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}