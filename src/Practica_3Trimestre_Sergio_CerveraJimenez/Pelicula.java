package Practica_3Trimestre_Sergio_CerveraJimenez;

public class Pelicula {

    /** ATRIBUTOS **/
    protected int Id;
    protected String Titulo;
    protected Genero genero;
    protected int Estreno;


    /** CONSTRUCTOR POR DEFECTO **/
    public Pelicula(){

    }

    /** CONSTRUCTOR PARAMETRIZADO **/

    public Pelicula(int id, String titulo, Genero genero, int estreno) {
        Id = id;
        Titulo = titulo;
        this.genero = genero;
        Estreno = estreno;
    }




    /** GETTERS AND SETTERS **/

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getEstreno() {
        return Estreno;
    }

    public void setEstreno(int estreno) {
        Estreno = estreno;
    }


    @Override
    public String toString() {
        return "Pelicula{" +
                "Id=" + Id +
                ", Titulo='" + Titulo + '\'' +
                ", genero=" + genero +
                ", Estreno=" + Estreno +
                '}';
    }
}
