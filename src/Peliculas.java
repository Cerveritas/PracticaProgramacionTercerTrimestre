import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Peliculas implements PeliculasInterface {
    Scanner sc = new Scanner(System.in);
    Pelicula p = new Pelicula();


    public static Connection conn;
    public static String query;
    public static Statement st;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/practica3", "root", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // METODO PARA CREAR LA TABLA (Película ) EN MYSQLWORKBENCH
    public void crearTabla() throws SQLException {
        query = "create table Pelicula (" +
                "id int primary key, " +
                "título VARCHAR(100), " +
                "género varchar(50), " +
                "estreno int)";
        st = conn.createStatement();
        st.executeUpdate(query);
        System.out.println("Tabla Pelicula creada correctamente...");
    }


    // METODO PARA ELIMINAR LA TABLA (PelÍcula ) EN MYSQLWORKBENCH
    public void eliminaTabla() throws SQLException {
        query = "drop table Pelicula";
        st = conn.createStatement();
        st.executeUpdate(query);
        System.out.println("La tabla Pelicula ha sido eliminada correctamente...");
    }


    // METODO PARA AGREGAR UNA PELÍCULA A NUESTRA TABLA
    public void crearPelicula(Pelicula p) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("insert into pelicula values (?,?,?,?)");
        System.out.println("Introduce el ID de la pelicula");
        p.Id = sc.nextInt();
        System.out.println("Introduce el titulo de la pelicula");
        p.Titulo = sc.next();
        System.out.println("Introduce el genero de la pelicula [ ROMANTICA, MIEDO, COMEDIA ]");
        p.genero = Genero.valueOf(sc.next().toUpperCase());
        System.out.println("Introduce el estreno de la pelicula");
        p.Estreno = sc.nextInt();

        ps.setInt(1, p.Id);
        ps.setString(2, p.Titulo);
        ps.setString(3, String.valueOf(p.genero));
        ps.setInt(4, p.Estreno);

        ps.executeUpdate();

        System.out.println("Registro incorporado correctamente a la tabla 'Pelicula'...");
    }


    // METODO PARA ELIMINAR UNA PELÍCULA DE NUESTRA TABLA
    public void eliminarPelicula(int id) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("delete from pelicula where id=?");
        System.out.println("Indica el ID de la película que deseas eliminar de la tabla: ");
        id = sc.nextInt();
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Registro eliminado correctamente...");
    }


    // METODO PARA BUSCAR UNA PELICULA POR SU ID
    public ArrayList<Pelicula> buscarPelicula(int id) throws SQLException {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select * from pelicula where id = ?");
        System.out.println("Introduzca el ID de la pelicula que desea buscar");
        id = sc.nextInt();

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            p.Id = rs.getInt("id");
            p.Titulo = rs.getString("título");
            p.genero = Genero.valueOf(rs.getString("género"));
            p.Estreno = rs.getInt("estreno");

            Pelicula pq = new Pelicula(p.Id, p.Titulo, p.genero, p.Estreno);
            peliculas.add(pq);


        }
        return peliculas;
    }


    // METODO QUE IMPRIME POR PANTALLA TODOS LOS DATOS DE LA TABLA
    public ArrayList<Pelicula> buscarTodo() throws SQLException {

        ArrayList<Pelicula> peliculas = new ArrayList<>();
        query = "select * from pelicula";
        st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            p.Id = rs.getInt("id");
            p.Titulo = rs.getString("título");
            p.genero = Genero.valueOf(rs.getString("género"));
            p.Estreno = rs.getInt("estreno");

            Pelicula pq = new Pelicula(p.Id, p.Titulo, p.genero, p.Estreno);
            peliculas.add(pq);



        }

        return peliculas;
    }


    // METODO QUE IMPRIME POR PANTALLA LAS PELICULAS SEGUN EL GÉNERO Y POR ORDEN DESCENDENTE
    public ArrayList<Pelicula> buscarPorGeneroOrdenarEstreno(String genero) throws SQLException {

        ArrayList<Pelicula> peliculas = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement("select * from pelicula where género = ? order by estreno DESC" );
        System.out.println("Introduzca el GÉNERO de la pelicula que desea buscar");
        genero = sc.next();

        ps.setString(1, genero);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            p.Id = rs.getInt("id");
            p.Titulo = rs.getString("título");
            p.genero = Genero.valueOf(rs.getString("género"));
            p.Estreno = rs.getInt("estreno");

            Pelicula pq = new Pelicula(p.getId(), p.getTitulo(), p.getGenero(), p.getEstreno());
            peliculas.add(pq);




        }
        return peliculas;
    }
}
