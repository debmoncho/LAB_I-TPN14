package lab_i.tpn14;

import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import entidades.Alumno;
import entidades.Inscripcion;
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
//        MateriaData data = new MateriaData();
//        for(Materia materia:data.listarMateria()){
//              
//           System.out.println(materia);
//           System.out.println("");
//       }
//----------------------------------------------------------------------------------------------
        //INSCRIBIMOS ALUMNO
        AlumnoData ad = new AlumnoData();

        MateriaData md = new MateriaData();

        InscripcionData id = new InscripcionData();

        //crea un alumno y luego lo busco con el metodo de ad
//        Alumno jeriko = ad.buscarAlumno(3);
//        
//        Materia musica = md.buscarMateria(3);
        // generamos una inscripcion
        //Inscripcion inscripcion = new Inscripcion(7, jeriko, musica);
        //y aca la guardamos
//        id.guardarInscripcion(inscripcion);
        // ACTUALIZAMOS NOTA AL MISMO ALUMNO ANTERIOR
        //y la guardamos
//        id.actualizarNota(3, 3, 10);
        // BORRAMOS INCRIPCION
//        id.borrarInscripcion(3, 3);
        // OBTENEMOS INCRIPCIONES
//        for (Inscripcion inscripcion : id.obtenerInscripciones()) {
//            
//            System.out.println("id: " + inscripcion.getIdInscripcion());
//            System.out.println("apellido: " + inscripcion.getAlumno().getApellido());
//            System.out.println("materia: " + inscripcion.getMateria().getNombre());
//            System.out.println(" ");
//        }
        // N de R: Tuvimos que activar "matematica", que estaba deshabilitada, por que nos producia
        //un error que decia que "la materia no existe". Una vez habilitada de nuevo, el programa
        // se pudo ejecutar.
        // INSCRIPCIONES POR ALUMNO
//        
//        for (Inscripcion inscripcion : id.obtenerInscripcionesPorAlumno(3)) {
//
//            System.out.println("id: " + inscripcion.getIdInscripcion());
//            System.out.println("apellido: " + inscripcion.getAlumno().getApellido());
//            System.out.println("materia: " + inscripcion.getMateria().getNombre());
//            System.out.println(" ");
//        }
//        
//             OBTENEMOS LA MATERIA CURSADAS CON EL ID DEL ALUMNO
//         for (Materia materia : id.obtenerMateriaCursada(2)) {
//
//            System.out.println("id: " + materia.getIdMateria());        
//            System.out.println("materia: " + materia.getNombre());
//             System.out.println("año: "+ materia.getAnioMateria());
//            System.out.println(" ");
//        }
//        OBTENEMOS LA  MATERIA NO CURSADAS CON EL ID DEL ALUMNO
//            for (Materia materia : id.obtenerMateriaNoCursada(2)) {
//
//            System.out.println("id: " + materia.getIdMateria());        
//            System.out.println("materia: " + materia.getNombre());
//             System.out.println("año: "+ materia.getAnioMateria());
//            System.out.println(" ");
//        }
//        
// OBTENEMOS ALUMNO POR MATERIA
        for (Alumno alumno : id.obtenerAlumnoPorMateria(1)) {

            System.out.println("id: " + alumno.getIdAlumno());
            System.out.println("nombre: " + alumno.getNombre());
            System.out.println("apellido: " + alumno.getApellido());
            System.out.println("fecha de Nacimiento " + alumno.getFechaNac());
            System.out.println(" ");
        }

    }

}
