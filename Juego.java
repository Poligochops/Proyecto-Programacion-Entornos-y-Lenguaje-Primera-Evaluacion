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

            if (!sc.hasNextInt())
            {
                System.out.println("¡Error! Introduce un número válido del 1 al 4.");
                sc.next();
                continue;
            }

            int opcionMenu = sc.nextInt();
            sc.nextLine();

            switch (opcionMenu)
            {
                case 1:
                    iniciarNuevaPartida(sc);
                    break;
                
                case 2:
                    System.out.println("Falta poner el ranking");
                    break;

                case 3:
                    ayudaMenu();
                    break;

                case 4:
                    System.out.println("¡Gracias por jugar a El Torneo de la Arena Gestral! Hasta pronto.");
                    juegoActivo = false;
                    break;
            
                default:
                    System.out.println("Opción invalida.");
                    break;
            }
        }
        while (juegoActivo);
    }

    //Texto que saldrá al elegir la opción de ayuda en el menú

    public static void ayudaMenu()
    {
        System.out.println("1.- Reglas y funcionamiento del juego:");
        System.out.println("");
        System.out.println("· El juego consistirá en tres combates seguidos.");
        System.out.println("· Tu personaje tendrá 100 de vida máxima y un daño de entre 10 y 20.");
        System.out.println("· Contarás con 3 pociones, cada una con la capacidad de curarte 25 de vida.");
        System.out.println("· Cada enemigo soltará 100 puntos, que se apuntarán junto al nombre que elijas al ranking.");
    }

    //Nombre personalizado que se verá en el ranking final

    public static void eleccionNombre(String nombreRanking)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Elige el nombre que quieres usar visible en el ranking:");
        nombreRanking = sc.nextLine();

        sc.close();
    }

    //Simular los combates por turnos

    public static boolean simularCombate(Scanner sc, Protagonista heroe, Enemigo enemigo, Curacion pociones)
    {
        while (heroe.getVidaActual() > 0 && enemigo.getVidaActual() > 0)
        {
            System.out.println("==============================================");
            System.out.println("Tu vida: " + heroe.getVidaActual() + " | Elixires disponibles: " + pociones.getCantidad());
            System.out.println("Vida de " + enemigo.getNombre() + ": " + enemigo.getVidaActual());
            System.out.println("==============================================");
            System.out.println("¿Qué quieres hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Usar poción: " + pociones.getNombrePoti());
            System.out.println("3. Abandonar partida");
            System.out.println("==============================================");
            System.out.print("Opción: ");

            //En caso de que no se elija bien ninguna de las opciones, saldrá este texto

            if (!sc.hasNextInt())
            {
                System.out.println("Opción inválida. Introduce 1, 2 o 3.");
                sc.next();
                continue;
            }

            int accion = sc.nextInt();
            sc.nextLine();

            boolean turnoConsumido = false;

            switch (accion)
            {
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

                    if (pociones.getCantidad() <= 0)
                    {
                        System.out.println("No te quedan " + pociones.getNombrePotiPlural());
                        turnoConsumido = false;

                    //En caso de tener la vida al máximo saldrá este texto

                    }
                    else if (heroe.getVidaActual() >= heroe.getVidaMax())
                    {
                        System.out.println("Ya tienes la vida al máximo");
                        turnoConsumido = false;

                    //En caso de poder usarse la poción

                    }
                    else
                    {
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

            if (turnoConsumido && enemigo.getVidaActual() > 0)
            {
                int danoEnemigo = (int) (Math.random() * (enemigo.getAtaqueMax() - enemigo.getAtaqueMin() + 1)) + enemigo.getAtaqueMin();
                heroe.setVidaActual(Math.max(0, heroe.getVidaActual() - danoEnemigo));
                System.out.println(enemigo.getNombre() + " contraataca y te hace " + danoEnemigo + " de daño");
            }
        }

        //En caso de morir devolverá un false

        if (heroe.getVidaActual() <= 0)
        {
            System.out.println("Has caído ante " + enemigo.getNombre());
            return false;
        }

        return true;
    }

    //Inicio de nueva partida y los tres combates contra los enemigos

    public static void iniciarNuevaPartida(Scanner sc)
    {
        System.out.print("Elige el nombre que quieres usar visible en el ranking: ");
        //Estos dos métodos son nativos del String. trim() elemina espacios en blanco y isEmpty() comprueba si está vacío

        String nombreJugador = sc.nextLine();
        if (nombreJugador.trim().isEmpty())
        {
            nombreJugador = "GustaveAnónimo";
        }

        iniciacicionPrimerCombate();

        //Volvemos a darle valores al protagonista para que cada vez que se inicie una nueva partida tenga estas mismos valores predefinidos

        Protagonista heroe = new Protagonista(nombreJugador, 120, 120, 10, 20);

        //Creamos el inventario donde se guardarán las pociones

        Curacion inventarioPociones = new Curacion("elixir de croma mediano", "elixires de croma medianos", 25, 3);

        //Aquí definimos a los tres enemigos creados en orden de dificultad

        Enemigo[] enemigos =
        {
            new Enemigo("Nevron", 70, 70, 10, 15, 100),
            new Enemigo("Nevron Volador", 50, 50, 15, 20, 100),
            new Enemigo("Petank", 200, 200, 8, 12, 100)
        };

        int enemigosDerrotados = 0;
        boolean partidaTerminada = false;
        boolean victoriaCompleta = false;

        //Bucle para recorrer los 3 combates seguidos

        for (int i = 0; i < enemigos.length && !partidaTerminada; i++)
        {
            //Depende del valor de i, mostrará una narrativa u otra

            switch (i) 
            {
                case 0: iniciacicionPrimerCombate(); break;
                case 1: transicionSegundoCombate(); break;
                case 2: transicionTercerCombate(); break;
            }

            Enemigo enemigoActual = enemigos[i];
            System.out.println("Combate " + (i + 1) + ": Te enfrentas a " + enemigoActual.getNombre());
            
            boolean enemigoDerrotado = simularCombate(sc, heroe, enemigoActual, inventarioPociones);

            if (!enemigoDerrotado)
            {
                partidaTerminada = true;
            }
            else
            {
                enemigosDerrotados++;
                System.out.println("¡Has vencido a " + enemigoActual.getNombre() + "!");
                
                //Si es el último combate y se gana, sale el texto de la victoria final

                if (i == enemigos.length - 1)
                {
                    victoriaCompleta = true;
                    victoriaFinal();
                }
            }
        }

        //Calculamos los puntos conseguidos por cada enemigo y se le suma la vida en caso de haber ganado todos los combates

        int puntuacionFinal = enemigosDerrotados * 100;
        if (victoriaCompleta)
        {
            puntuacionFinal += heroe.getVidaActual();
            System.out.println("¡VICTORIA TOTAL! Has completado la aventura gestral.");
        }
        else
        {
            System.out.println("Fin de la partida. Enemigos derrotados: " + enemigosDerrotados);
        }

        System.out.println("Tu puntuación final ha sido: " + puntuacionFinal);
    }

    //Texto anterior al primer combate

    public static void iniciacicionPrimerCombate()
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

    //Transición entre el primer y segundo combate

    public static void transicionSegundoCombate()
    {
        System.out.println("Has derrotado al Nevron, pero el aire comienza a volverse denso...");
        pausaTiempo(1500);
        System.out.println("Un sonido agudo corta el silencio. Una sombra flotante se precipita desde el cielo.");
        pausaTiempo(2000);
        System.out.println("Es el Nevron Volador, prepárate para el siguiente asalto.");
        pausaTiempo(2000);
    }

    //Transición entre el segundo y tercer combate

    public static void transicionTercerCombate()
    {
        System.out.println("El Nevron Volador cae rendido al suelo");
        pausaTiempo(1500);
        System.out.println("La tierra comienza a temblar bajo tus pies. Un coloso pesado emerge de las profundidades.");
        pausaTiempo(2000);
        System.out.println("Es un Petank, una gran bola de metal acorazado. Este es tu combate más duro.");
        pausaTiempo(2000);
    }

    //Victoria después del tercer combate

    public static void victoriaFinal()
    {
        System.out.println("¡VICTORIA! Has logrado derrotar a Petank");
        pausaTiempo(1500);
        System.out.println("Golgra, la líder de los gestrales te da la enorabuena por tu gran perseverancia.");
        pausaTiempo(2000);
        System.out.println("Como recompensa, te da una peluca parecida a sus pelos en forma de brocha de pincel.");
        pausaTiempo(2000);
        System.out.println("Sabes que nunca la usarás, pero aun así estas contento de haber completado el torneo.");
        pausaTiempo(2000);
    }

    //Método para hacer pausas entre SOUTs

    public static void pausaTiempo(int milisegundos)
    {
        try
        {
            Thread.sleep(milisegundos);
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
