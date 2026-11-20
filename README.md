El Torneo de la Arena Gestral

    Proyecto de programación, lenguaje de marcas y entornos de desarrollo en Java desarrollado para el módulo de Programación de 1º de DAM. Se trata de un juego por turnos ambientado en el universo de expedition 33, donde el jugador debe superar tres combates consecutivos y registrar su puntuación en un ranking.

Descripción del juego

    El objetivo del juego es derrotar a tres enemigos seguidos:

        Nevron (70 de vida | 10-15 de daño)

        Nevron Volador (50 de vida | 15-20 de daño)

        Petank (150 de vida | 8-12 de daño)

    El jugador controla a un protagonista que cuenta con 120 puntos de vida, un ataque aleatorio de entre 12 y 25 puntos de daño, y un inventario con 3 elixires de croma medianos que curan 25 puntos de vida cada uno.

Sistema de puntuación

    Cada enemigo derrotado otorga 100 puntos.

    Si se completan los tres combates con éxito, se suma la vida restante del protagonista a la puntuación final.

    Los 10 mejores resultados se guardan automáticamente en un archivo XML externo.

Estructura del proyecto

    El proyecto está dividido en los siguientes archivos:

        Juego.java: Clase principal que contiene el método main, el menú de opciones, la narrativa del juego y la lógica de los combates por turnos.

        Personaje.java: Clase base que define los atributos comunes (nombre, vida máxima, vida actual, ataque mínimo y máximo) y los métodos básicos de los enemigos y protagonista.

        Protagonista.java: Clase que hereda de Personaje y representa al jugador.

        Enemigo.java: Clase que hereda de Personaje y añade los puntos que otorga el enemigo al ser derrotado.

        Curacion.java: Clase encargada de gestionar las curaciones, su cantidad disponible y la vida que recupera.

        rankingXML.java: Clase encargada de leer, actualizar, ordenar de mayor a menor, y guardar el Top 10 de puntuaciones utilizando arrays paralelos.

        ranking.xml: Archivo donde se almacenan los nombres y puntuaciones de los jugadores.

        ranking.dtd: Define la estructura y las etiquetas válidas que debe tener el archivo XML.

        ranking.xslt y ranking.css: Hojas de estilo para poder visualizar el archivo ranking.xml como una tabla HTML directamente desde el navegador.

Conceptos aplicados

    En este proyecto se han puesto en práctica los siguientes contenidos vistos en clase:

        Programación Orientada a Objetos (clases, objetos, constructores, encapsulamiento con getters y setters y herencia con extends y super).

        Estructuras de control (bucles while, do-while, for y condicionales if-else, switch).

        Uso de arrays paralelos para gestionar el ranking.

        Control básico de errores de entrada por teclado con Scanner.

        Lectura y escritura de ficheros XML, validación DTD y estilos XSLT/CSS.