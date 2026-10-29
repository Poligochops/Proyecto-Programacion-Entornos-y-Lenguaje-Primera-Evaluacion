//La clase donde se definirán los enemigos

public class Enemigos
{
    //Atributos

    String nombre;
    int vida;
    int ataqueMin;
    int ataqueMax;
    int experienciaSoltada;
    int puntuacionSoltadaRanking;

    //El constructor de la clase enemigos

    public Enemigos(String nombre, int vida, int ataqueMin, int ataqueMax, int experienciaSoltada, int puntuacionSoltadaRanking)
    {
        this.nombre = nombre;
        this.vida = vida;
        this.ataqueMin = ataqueMin;
        this.ataqueMax = ataqueMax;
        this.experienciaSoltada = experienciaSoltada;
        this.puntuacionSoltadaRanking = puntuacionSoltadaRanking;
    }

    //Métodos

    public void mostrarDatos()
    {
        System.out.println("Nombre: " + nombre);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque mínimo: " + ataqueMin);
        System.out.println("Ataque máximo: " + ataqueMax);
        System.out.println("Experiencia soltada: " + experienciaSoltada);
        System.out.println("Puntuación soltada para el ranking: " + puntuacionSoltadaRanking);
    }

    //Setters y Getters

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

    //Mostrar los datos elegidos

    public static void main(String[] args)
    {
        Enemigos nevron = new Enemigos("Nevron", 65, 5, 15, 30, 100);
        Enemigos nevronVolador = new Enemigos("Nevron Volador", 50, 10, 20, 35, 100);
        Enemigos petank = new Enemigos("Petank", 200, 5, 10, 120, 100);

        System.out.println("------------------------------------------");
        
        nevron.mostrarDatos();
        System.out.println("------------------------------------------");

        nevronVolador.mostrarDatos();
        System.out.println("------------------------------------------");

        petank.mostrarDatos();
        System.out.println("------------------------------------------");
    }
}