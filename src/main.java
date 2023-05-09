import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    // DECLARACION DE MI ESQUEMA DE COLORES
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static void main(String[] args) throws SQLException {



        Peliculas pel = new Peliculas();
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        Pelicula pelicula = new Pelicula();




        do {
            System.out.println(ANSI_CYAN+"------------------------------------------------------------------------------﹁");
            System.out.println("Pulse:                                                                        |");
            System.out.println("0 - Salir Del Programa                                                        |");
            System.out.println("1 - Crear Tabla Película                                                      |");
            System.out.println("2 - Eliminar Tabla Película                                                   |");
            System.out.println("3 - Crear Película                                                            |");
            System.out.println("4 - Eliminar Película Por ID                                                  |");
            System.out.println("5 - Buscar Película Por ID e Imprimir Información                             |");
            System.out.println("6 - Buscar Todas Las Películas e Imprimir Todas Las Películas                 |");
            System.out.println("7 - Buscar Por Género y Por Órden Descendente De Estreno e Imprimir           |");
            System.out.println("------------------------------------------------------------------------------」"+ANSI_RESET);

            opcion = sc.nextInt();

            switch (opcion){
                case 0:
                    System.out.println(ANSI_YELLOW+"❤ GRACIAS POR USAR EL PROGRAMA ❤");
                    System.out.println("   _____   _____                _____   _____               _____     _   _   _ \n" +
                            "  / ____| |  __ \\      /\\      / ____| |_   _|     /\\      / ____|   | | | | | |\n" +
                            " | |  __  | |__) |    /  \\    | |        | |      /  \\    | (___     | | | | | |\n" +
                            " | | |_ | |  _  /    / /\\ \\   | |        | |     / /\\ \\    \\___ \\    | | | | | |\n" +
                            " | |__| | | | \\ \\   / ____ \\  | |____   _| |_   / ____ \\   ____) |   |_| |_| |_|\n" +
                            "  \\_____| |_|  \\_\\ /_/    \\_\\  \\_____| |_____| /_/    \\_\\ |_____/    (_) (_) (_)");

                    System.out.println("________________________________█████_____█████\n" +
                            "______________________________███____██_██_____███\n" +
                            "_____________________________██________██__________██\n" +
                            "____________________________██__________█____________██\n" +
                            "________██████____________██________________________██\n" +
                            "_____███████████________██________________________██\n" +
                            "____█████████████_______██_______________________██\n" +
                            "___███████████████______██______________________██\n" +
                            "___████████████████______██___________________██\n" +
                            "___████████████████_______██_________________██\n" +
                            "____███████████████_______███_______________██\n" +
                            "_______███████████_______██__██_____________██\n" +
                            "___________███████______████___██__________██\n" +
                            "____██████__██████████████_____██_____██\n" +
                            "__██████████████████████________██__██\n" +
                            "_████████████████████_____________████\n" +
                            "██_█████_████████████_______________█\n" +
                            "█__█_██__████████████\n" +
                            "_____█__████████████\n" +
                            "_______█████████████\n" +
                            "_______██████████████\n" +
                            "_______███████████████\n" +
                            "________███████████████\n" +
                            "_______███████__████████\n" +
                            "______███████_____███████\n" +
                            "____█████████________██████\n");

                    break;

                case 1:
                    pel.crearTabla();
                    break;

                case 2:
                    pel.eliminaTabla();
                    break;

                case 3:
                    pel.crearPelicula(pelicula);
                    break;

                case 4:
                    pel.eliminarPelicula(pelicula.Id);
                    break;

                case 5:
                    imprimir_arraylist(pel.buscarPelicula(pelicula.Id));
                    break;

                case 6:
                    imprimir_arraylist(pel.buscarTodo());

                    break;

                case 7:
                    imprimir_arraylist(pel.buscarPorGeneroOrdenarEstreno(String.valueOf(pelicula.genero)));
                    break;

                default:
                    System.out.println(ANSI_RED+"ERROR!!  ERROR!!  ERROR!!  ERROR!!");
                    System.out.println("El numero introducido es incorrecto, intentelo de nuevo");
                    break;
            }
        } while (opcion != 0);
    }
    private static void imprimir_arraylist(ArrayList<Pelicula> listado_peliculas) {

        for (int i = 0; i < listado_peliculas.size() ; i++){
            System.out.println(listado_peliculas.get(i));
        }
    }

}
