import java.sql.SQLException;
import java.util.ArrayList;

public interface PeliculasInterface {



    public void crearTabla() throws SQLException;

    public void eliminaTabla() throws SQLException;

    public void crearPelicula(Pelicula pelicula) throws SQLException;

    public void eliminarPelicula(int id) throws SQLException;

    public ArrayList<Pelicula> buscarPelicula(int id) throws SQLException;

    ArrayList<Pelicula> buscarTodo() throws SQLException;

    ArrayList<Pelicula> buscarPorGeneroOrdenarEstreno(String genero) throws SQLException;
}
