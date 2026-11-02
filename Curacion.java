public class Curacion
{
    //Atributos

    private String nombrePoti;
    private String nombrePotiPlural;
    private int curacionVida;
    private int cantidad;
    private int nivelPoti;

    //Constructores

    public Curacion (String nombrePoti,String nombrePotiPlural, int curacionVida, int cantidad, int nivelPoti)
    {
        this.nombrePoti = nombrePoti;
        this.nombrePotiPlural = nombrePotiPlural;
        this.curacionVida = curacionVida;
        this.cantidad = cantidad;
        this.nivelPoti = nivelPoti;

    }
    
    //Métodos

    public void mostrarDatos()
    {
        System.out.println("Al usar esta poción se ha curado: " + curacionVida + " de vida.");
        System.out.println("Quedan " + cantidad + " " + nombrePotiPlural);
    }

    //Getters y Setters

    public String getNombrePoti() {
        return nombrePoti;
    }

    public void setNombrePoti(String nombrePoti) {
        this.nombrePoti = nombrePoti;
    }

    public String getNombrePotiPlural() {
        return nombrePotiPlural;
    }

    public void setNombrePotiPlural(String nombrePotiPlural) {
        this.nombrePotiPlural = nombrePotiPlural;
    }

    public int getCuracionVida() {
        return curacionVida;
    }

    public void setCuracionVida(int curacionVida) {
        this.curacionVida = curacionVida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNivelPoti() {
        return nivelPoti;
    }

    public void setNivelPoti(int nivelPoti) {
        this.nivelPoti = nivelPoti;
    }

    public static void main(String[] args)
    {
        Curacion chiquiPocion = new Curacion ("elixir de croma pequeño", "elixires de croma pequeños", 10, 5, 1);
        Curacion mediumPocion = new Curacion ("elixir de croma mediano", "elixires de croma medianos", 25, 3, 1);
        Curacion gigaPocion = new Curacion ("elixir de croma grande", "elixires de croma grandes", 60, 1, 1);

        System.out.println("-----------------------------------------------------");
        chiquiPocion.mostrarDatos();
        System.out.println("-----------------------------------------------------");
        mediumPocion.mostrarDatos();
        System.out.println("-----------------------------------------------------");
        gigaPocion.mostrarDatos();
        System.out.println("-----------------------------------------------------");
    }
}
