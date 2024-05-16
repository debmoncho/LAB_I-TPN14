
package lab_i.tpn14;

import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import entidades.Alumno;
import java.sql.*;
import java.time.LocalDate;


public class LAB_ITPN14 {


    public static void main(String[] args) {
        
        
        Connection con = Conexion.getConexion();
        
        // PROBANDO CAMBIO A VER
        
        Alumno pedro = new Alumno(5,40567231, "Luna", "Juan Pedro", LocalDate.of(1997,11,21), true);
        AlumnoData data = new AlumnoData();
//        data.guardarAlumno(pedro);
//         data.modificarAlumno(pedro);      
            data.eliminarAlumno(5);
    }
    
}
