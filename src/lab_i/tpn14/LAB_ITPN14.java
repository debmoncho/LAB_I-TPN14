package lab_i.tpn14;

import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import AccesoADatos.MateriaData;
import entidades.Alumno;
import entidades.Materia;
import java.sql.*;
import java.time.LocalDate;

public class LAB_ITPN14 {

    public static void main(String[] args) {

        Connection con = Conexion.getConexion();

        // PROBANDO CAMBIO A VER
//        Alumno pedro = new Alumno(5, 40567231, "Luna", "Juan Pedro", LocalDate.of(1997, 11, 21), true);
//        AlumnoData data = new AlumnoData();
//        data.guardarAlumno(pedro);
//         data.modificarAlumno(pedro);      
//            data.eliminarAlumno(5);

// BUSCAR ALUMNO POR ID
//        Alumno encontrado= data.buscarAlumno(4);
//        
//        System.out.println("DNI "+encontrado.getDni());
//        System.out.println("Apellido "+encontrado.getApellido());
//        System.out.println("Nombre "+encontrado.getNombre());
//        
//        Alumno encontrado = data.buscarAlumnoPorDni(31594876);
//
//        if (encontrado != null) {
//            System.out.println("DNI " + encontrado.getDni());
//            System.out.println("Apellido " + encontrado.getApellido());
//            System.out.println("Nombre " + encontrado.getNombre());
//        }
//        AlumnoData data = new AlumnoData();
        
//        for(Alumno alumno:data.listarAlumno()){
            //manera ordenada de ver los datos de los elementos
//            System.out.println(alumno.getDni());
//            System.out.println(alumno.getApellido());
//            System.out.println(alumno.getNombre());
//            System.out.println(alumno.getFechaNac());
//            System.out.println("");
//      ver los elementos con un to string
//            System.out.println(alumno);
//            System.out.println("");
//        }

//      ----------------------------------------------------------------------------------
        // AGREGAR MATERIA
//        Materia historia = new Materia("Historia", 4, true);
//        MateriaData data = new MateriaData();
        //data.guardarMateria(historia);
        
        // MODIFICAR MATERIA - GEOGRAFIA
        
        //Materia historia = new Materia(5,"Historia Argentina", 5, true);
        //MateriaData data = new MateriaData();
        //data.modificarMateria(historia);
        
        // ELIMINAMOS UNA MATERIA POR ESTADO
        //MateriaData data = new MateriaData();
        //data.eliminarMateria(1);
       
        // BUSCAR MATERIA POR ID
        //MateriaData data = new MateriaData();
        //Materia encontrada= data.buscarMateria(3);
        
        //System.out.println("Id: " + encontrada.getIdMateria());
        //System.out.println("Nombre: "+encontrada.getNombre());
        //System.out.println("Año: " + encontrada.getAnioMateria());
        
        // BUSCAR MATERIA POR AÑO
        //MateriaData data = new MateriaData();
        //Materia encontrada= data.buscarMateriaPorAnio(1);
        
        //System.out.println("Año: " + encontrada.getAnioMateria());
        //System.out.println("Id: " + encontrada.getIdMateria());
        //System.out.println("Nombre: "+encontrada.getNombre());
        //System.out.println("");
        
        // LISTAR MATERIAS ACTIVAS
        MateriaData data = new MateriaData();
        for(Materia materia:data.listarMateria()){
              
           System.out.println(materia);
           System.out.println("");
       }
    }

}
