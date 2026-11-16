import java.util.Scanner;

public class Juego
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        boolean juegoActivo = true;

        //Menú

        System.out.println("Selecciona tu siguiente paso");
        System.out.println("(1: Nueva partida, 2: Ranking, 3: Ayuda, 4: Salir):");
        int opcionMenu = sc.nextInt();

        do
        {
            switch (opcionMenu) {
                case 1:
                    
                    break;
                
                case 2:
                    
                    break;

                case 3:
                    
                    break;

                case 4:
                    
                    break;
            
                default:
                    break;
            }
        }
        while (juegoActivo);
    }

    //Texto que saldrá al elegir la opción de ayuda en el menú

    public void ayudaMenu()
    {
        System.out.println("1.- Reglas y funcionamiento del juego:");
        System.out.println("");
        System.out.println("· El juego consistirá en tres combates seguidos.");
        System.out.println("· Tu personaje tendrá 120 de vida máxima y un daño de entre 10 y 20.");
        System.out.println("· Contarás con 3 pociones, cada una con la capacidad de curarte 25 de vida.");
        System.out.println("· Cada enemigo soltará 100 puntos, que se apuntarán junto al nombre que elijas al ranking.");
    }

    //Nombre personalizado que se verá en el ranking final

    public void eleccionNombre(String nombreRanking)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Elige el nombre que quieres usar visible en el ranking:");
        nombreRanking = sc.nextLine();

        sc.close();
    }

    //Texto anterior al primer combate

    public void iniciacicionPrimerCombate()
    {
        System.out.println("Has sido invitado a la arena gestral, donde extraordinarias criaturas");
        System.out.println("(los gestrales) con un pelo parecido a un pincel combaten por puro gusto.");
        pausaTiempo(3000);
        System.out.println("");
        System.out.println("Te proponen hacer tres combates contra diferentes criaturas del reino.");
        pausaTiempo(2000);
        System.out.println("");
        System.out.println("Tu aceptas, ya que te gustan los retos.");
        pausaTiempo(2000);
        System.out.println("");
        System.out.println("Preparate ahí viene tu primer adversario.");
    }

    //Método para hacer pausas entre SOUTs

    public void pausaTiempo(int milisegundos)
    {
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
