public class Curacion
{
    //Atributos

    private String nombrePoti;
    private String nombrePotiPlural;
    private int curacionVida;
    private int cantidad;

    //Constructores

    public Curacion (String nombrePoti,String nombrePotiPlural, int curacionVida, int cantidad)
    {
        this.nombrePoti = nombrePoti;
        this.nombrePotiPlural = nombrePotiPlural;
        this.curacionVida = curacionVida;
        this.cantidad = cantidad;
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

    public static void main(String[] args)
    {
        Curacion mediumPocion = new Curacion ("elixir de croma mediano", "elixires de croma medianos", 25, 3);

        System.out.println("-----------------------------------------------------");
        mediumPocion.mostrarDatos();
    }
}
