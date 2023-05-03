package Practica_3Trimestre_Sergio_CerveraJimenez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class Peliculas implements PeliculasInterface{
    Scanner sc = new Scanner(System.in);

    Pelicula p = new Pelicula();


    public static Connection conn;
    public static String query;
    public static Statement st;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica3", "root", "Myandroidop5");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // METODO PARA CREAR LA TABLA (Pelicula ) EN MYSQLWORKBENCH
    public void crearTabla() throws SQLException {
        query = "create table Pelicula ("+
                "id int primary key, "+
                "título VARCHAR(100), "+
                "género varchar(50), "+
                "estreno int)";
        st = conn.createStatement();
        st.executeUpdate(query);
        System.out.println("Tabla Pelicula creada correctamente...");
    }


    // METODO PARA ELIMINAR LA TABLA (Pelicula ) EN MYSQLWORKBENCH
    public void eliminaTabla() throws SQLException {
        query = "drop table Pelicula";
        st = conn.createStatement();
        st.executeUpdate(query);
        System.out.println("La tabla Pelicula ha sido eliminada correctamente...");
    }


    public void crearPelicula(Pelicula p) throws SQLException {

        System.out.println("Indicame el ID");
            int numero = sc.nextInt();
       /* System.out.println("Indicame el Titulo");
            sc.next(p.Titulo);
        System.out.println("Indicame el genero ROMÁNTICA, MIEDO, COMEDIA");
            sc.next(String.valueOf(p.genero));
        System.out.println("Indicame el año de estreno");
            sc.nextInt(p.Estreno);
*/
        /*query = */
        st = conn.createStatement();
        st.executeUpdate(query);
        System.out.println("Pelicula insertada correctamente...");




    }


    public void eliminarPelicula(int id) {

    }


    public Pelicula buscarPelicula(int id) {
        return null;
    }


    public ArrayList<Pelicula> buscarTodo() {
        return null;
    }


    public ArrayList<Pelicula> buscarPorGeneroEstreno(int estreno, String genero) {
        return null;
    }
}
