package javamongo_nintendo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class Conexion {
    DB baseDatos;
    DBCollection coleccion;
    BasicDBObject documento = new BasicDBObject();
    
    public Conexion(){
        try {
            Mongo mongo = new Mongo("localhost",27017);
            baseDatos = mongo.getDB("nintendo");
            coleccion = baseDatos.getCollection("consolas");
            System.out.println("Conexion a Mongo exitosa");
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
        }
    }  
    
    public boolean Insertar(String consola){
        documento.put("Nombre", consola);
        coleccion.insert(documento);
        
        System.out.println("Consola insertada");
        return true;
    }
    
    public void Mostrar(){
        DBCursor cursor = coleccion.find();
        
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    
    public boolean Actualizar(String consolaVieja, String consolaNueva){
        documento.put("Nombre", consolaVieja);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("Nombre", consolaNueva);
        coleccion.findAndModify(documento, documentoNuevo);
        
        System.out.println("Consola actualizada");
        return true;
    }
    
    public boolean Eliminar(String consola){
        documento.put("Nombre", consola);
        coleccion.remove(documento);
        
        System.out.println("Consola eliminada");
        return true;
    }
    
}
