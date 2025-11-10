package edu.masanz.da.lp;

/**
 * Clase principal para ejecutar la aplicación de gestión de ligas de paddle.
 * Utiliza la clase GestorLigas para gestionar las ligas y la clase Gui para la interacción con el usuario.
 */
public class App {

    private GestorLigas gestorLigas;

    /**
     * Constructor de la clase App.
     */
    public App() {
        // TODO 11: instancia el GestorLigas HECHO DUDAS
        //  e inicializa las ligas utilizando la clase Init
        gestorLigas = new GestorLigas();
        Init.crearLigas(gestorLigas);




    }

    /**
     * Método principal para ejecutar la aplicación.
     */
    public void run() {
        // TODO 12: en un bucle muestra el menú,
        //  lee la opción y
        //  ejecuta la opción hasta que se elija salir. HECHO

        while (true) {
            Gui.mostrarMenu();
            int n = Gui.leerNumero("Dame un número");
            ejecutarOpcion(n);
            if (n ==  0) {
                break;
            }
        }









    }

    /**
     * Ejecuta la opción seleccionada del menú.
     * @param numOpc Número de opción seleccionada.
     */
    private void ejecutarOpcion(int numOpc) {
        // TODO 13: implementa la ejecución de las opciones del menú utilizando un switch. HECHO
        // Llama a los métodos correspondientes para cada opción.
        switch (numOpc) {
            case 1:
                listarEquiposLigas();


            case 2:
                mostrarTablaResultadosLiga();
                break;

            case 3:
                listarCampeonesLigas();
                break;

            case 4:
                anotarMarcadoresLiga();
                break;
        }




















    }

    /**
     * Lista los equipos de las ligas disponibles.
     */
    private void listarEquiposLigas() {
        // TODO 14: muestra la lista de ligas, lee el número de liga y muestra la lista de equipos de la liga seleccionada. HECHO
        Gui.mostrarTexto("Ligas disponibles: ");
        Gui.mostrarTexto(gestorLigas.getListaLigas());
        int num = Gui.leerNumero("Elige un numero de liga");
        Gui.mostrarTexto("Equipos de la liga: ");
        gestorLigas.getListaEquipos(num);
    }

    /**
     * Lista los campeones de las ligas.
     */
    private void listarCampeonesLigas() {
        // TODO 15: muestra el listado de campeones de todas las ligas. HECHO
        String txt = gestorLigas.getListadoCampeonesLigas();
        Gui.mostrarTexto(txt);
    }

    /**
     * Muestra la tabla de resultados de una liga seleccionada.
     */
    private void mostrarTablaResultadosLiga() {
        // TODO 16: muestra la lista de ligas, lee el número de liga y muestra la tabla de resultados de la liga seleccionada. HECHO
        Gui.mostrarTexto(gestorLigas.getListaLigas());
        int numLiga = Gui.leerNumero("Elige una liga: ");
        Gui.mostrarTexto(gestorLigas.getTablaResultadosLiga(numLiga));
    }

    /**
     * Muestra la tabla de resultados de una liga específica.
     * @param numLiga Número de la liga.
     */
    private void mostrarTablaResultadosLiga(int numLiga) {
        // TODO 17: muestra la tabla de resultados de la liga indicada. HECHO
        Gui.mostrarTexto("Resultados actuales de la liga " + gestorLigas.getNombreLiga(numLiga) + " : ");
        Gui.mostrarTexto(gestorLigas.getTablaResultadosLiga(numLiga));

    }

    /**
     * Anota los marcadores de los partidos de una liga seleccionada.
     */
    private void anotarMarcadoresLiga() {
        // TODO 18: Para anotar los marcadores de los partidos de una liga seleccionada,
        // muestra la lista de ligas, lee el número de liga, muestra la lista de equipos,
        // permite al usuario seleccionar dos equipos y anotar los marcadores de sus partidos.
        // Muestra la tabla de resultados antes y después de anotar los marcadores.
        // Permite repetir el proceso hasta que el usuario decida salir.

        Gui.mostrarTexto(gestorLigas.getListaLigas());
        int numLiga = Gui.leerNumero("Elige una liga de 1 a 4: ");
        Gui.mostrarTexto(gestorLigas.getListaEquipos(numLiga));
        while (true) {
            mostrarTablaResultadosLiga(numLiga);
            Gui.mostrarTexto("Selecciona el número de los dos equipos del partido:");
            int e1 = Gui.leerNumero("Número equipo fila    (1-4): ");
            int e2 = Gui.leerNumero("Número equipo columna (1-4): ");
            for (int i = 1; i <= 3; i++) {
                int v1 = Gui.leerNumero("Marcador" + i + " equipo: " + gestorLigas.getEquipo(numLiga, e1));
                int v2 = Gui.leerNumero("Marcador" + i + " equipo: " + gestorLigas.getEquipo(numLiga, e2));
                gestorLigas.setMarcadorPartido(numLiga, e1, e2, i, v1, v2);
            }

        }
    }

    /**
     * Muestra un mensaje de salida: "Saliendo...".
     */
    private void salir() {
        Gui.mostrarTexto("Saliendo...");
    }

    /**
     * Muestra un mensaje de opción no válida: "Opción no válida".
     */
    private void opcionNoValida() {
        Gui.mostrarTexto("Opción no válida");
    }


}
