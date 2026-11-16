import java.util.Scanner;

public class Juego
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        boolean juegoActivo = true;

        do
        {
            //Menú
            
            System.out.println("========================================");
            System.out.println("     El TORNEO DE LA ARENA GESTRAL  ");
            System.out.println("========================================");
            System.out.println("Selecciona tu siguiente paso:");
            System.out.println("1: Nueva partida");
            System.out.println("2: Ranking");
            System.out.println("3: Ayuda");
            System.out.println("4: Salir");
            System.out.print("Opción: ");

            //En caso de que no sea un número lo que se escribe, saldrá este mensaje
            if (!sc.hasNextInt()) {
                System.out.println("¡Error! Introduce un número válido del 1 al 4.");
                sc.next();
                continue;
            }

            int opcionMenu = sc.nextInt();
            sc.nextLine();

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
        System.out.println("· Tu personaje tendrá 100 de vida máxima y un daño de entre 10 y 20.");
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

    //Simular los combates por turnos

    public static boolean simularCombate(Scanner sc, Protagonista heroe, Enemigo enemigo, Curacion pociones)
    {
        while (heroe.getVidaActual() > 0 && enemigo.getVidaActual() > 0) {
            System.out.println("----------------------------------------");
            System.out.println("Tu vida: " + heroe.getVidaActual() + "/" + heroe.getVidaMax() + " | Elixires disponibles: " + pociones.getCantidad());
            System.out.println("Vida de " + enemigo.getNombre() + ": " + enemigo.getVidaActual() + "/" + enemigo.getVidaMax());
            System.out.println("¿Qué quieres hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Usar poción (" + pociones.getNombrePoti() + ")");
            System.out.println("3. Abandonar partida");
            System.out.print("Opción: ");

            //En caso de que no se elija bien ninguna de las opciones, saldrá este texto

            if (!sc.hasNextInt()) {
                System.out.println("Opción inválida. Introduce 1, 2 o 3.");
                sc.next();
                continue;
            }

            int accion = sc.nextInt();
            sc.nextLine();

            boolean turnoConsumido = false;

            switch (accion) {
                //La primera opción sirve para atacar al enemigo
                case 1:
                    int danoHeroe = (int) (Math.random() * (heroe.getAtaqueMax() - heroe.getAtaqueMin() + 1)) + heroe.getAtaqueMin();
                    enemigo.setVidaActual(Math.max(0, enemigo.getVidaActual() - danoHeroe));
                    System.out.println("Atacas a " + enemigo.getNombre() + " y le haces " + danoHeroe + " de daño");
                    turnoConsumido = true;
                    break;

                //La segunda opción sirve para usar una poción
                case 2:
                    //En caso de que no te queden pociones saldra este texto
                    if (pociones.getCantidad() <= 0) {
                        System.out.println("No te quedan " + pociones.getNombrePotiPlural());
                        turnoConsumido = false;
                    //En caso de tener la vida al máximo saldrá este texto
                    } else if (heroe.getVidaActual() >= heroe.getVidaMax()) {
                        System.out.println("Ya tienes la vida al máximo");
                        turnoConsumido = false;
                    //En caso de poder usarse la poción
                    } else {
                        int nuevaVida = Math.min(heroe.getVidaMax(), heroe.getVidaActual() + pociones.getCuracionVida());
                        heroe.setVidaActual(nuevaVida);
                        pociones.setCantidad(pociones.getCantidad() - 1);
                        
                        System.out.println("Has utilizado un elixir");
                        pociones.mostrarDatos();
                        turnoConsumido = true;
                    }
                    break;
                    
                //La tercera opción es el texto que saldrá en caso de que abandones la partida
                case 3:
                    System.out.println("Has abandonado la aventura.");
                    return false;

                default:
                    System.out.println("Opción incorrecta. Inténtalo de nuevo.");
                    turnoConsumido = false;
                    break;
            }

            //Si el enemigo sigue vivo y se acaba tu turno, el te ataca
            if (turnoConsumido && enemigo.getVidaActual() > 0) {
                int danoEnemigo = (int) (Math.random() * (enemigo.getAtaqueMax() - enemigo.getAtaqueMin() + 1)) + enemigo.getAtaqueMin();
                heroe.setVidaActual(Math.max(0, heroe.getVidaActual() - danoEnemigo));
                System.out.println(enemigo.getNombre() + " contraataca y te hace " + danoEnemigo + " de daño");
            }
        }

        //En caso de morir devolverá un false
        if (heroe.getVidaActual() <= 0) {
            System.out.println("Has caído ante " + enemigo.getNombre());
            return false;
        }

        return true;
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
