public class DefinicionEnemigos
{
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
