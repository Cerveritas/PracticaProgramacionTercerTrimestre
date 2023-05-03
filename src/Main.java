import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {


        String url = "jdbc:mysql://localhost:3306/PracticaProgramacion";
        String user = "root";
        String pwd = "Myandroidop5";
        Connection conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("Conexion establecida");


        String query = "create table paciente (" +
                "dni varchar(9) primary key, "+
                "nombre varchar(30) not null, "+
                "apellidos varchar(100), "+
                "n_operaciones int )";
        Statement st = conn.createStatement();
        st.execute(query);
        System.out.println("tabla creada correctamente");



    }
}