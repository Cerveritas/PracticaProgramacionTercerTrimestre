package Practica_3Trimestre_Sergio_CerveraJimenez;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PeliculasInterface {



    public void crearTabla() throws SQLException;

    public void eliminaTabla() throws SQLException;

    public void crearPelicula(Pelicula pelicula) throws SQLException;

    public void eliminarPelicula(int id);

    public Pelicula buscarPelicula(int id);

    ArrayList<Pelicula> buscarTodo();

    ArrayList<Pelicula> buscarPorGeneroEstreno(int estreno, String genero);










}
