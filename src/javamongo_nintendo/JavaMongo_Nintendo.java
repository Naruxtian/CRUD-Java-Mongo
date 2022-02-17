package javamongo_nintendo;
/**
 *
 * @author Chris
 */
public class JavaMongo_Nintendo {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        
        //con.Insertar("Nintendo DS");
        //con.Insertar("Nintendo Wii U");
        //con.Mostrar();
        //con.Actualizar("Nintendo DS", "Nintendo 3DS");
       //con.Mostrar();
        con.Eliminar("Nintendo Wii U");
        con.Mostrar();
    }
    
}