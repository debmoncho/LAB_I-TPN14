
package AccesoADatos;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class InscripcionData {
    
    
    private Connection con = null;
    
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();
    

    public InscripcionData() {
        con = Conexion.getConexion();
    }
    
    
    public void guardarInscripcion(Inscripcion inscripcion){
        
        String sql = "INSERT INTO inscripcion ( nota, idAlumno, idMateria) VALUES (?, ?, ?)";
    
        try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(3, inscripcion.getMateria().getIdMateria());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                
                inscripcion.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion registrada exitosamente!");

            }
            
            ps.close();
        
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al guardar inscripción");
            
        }
        
    }
    
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
    
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
        
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            
            int exito = ps.executeUpdate();
            
            if(exito > 0){
                JOptionPane.showMessageDialog(null, "Nota actualizada exitosamente!");
            }
            
            ps.close();
        
        
        } catch (SQLException ex) {
            
            
            JOptionPane.showMessageDialog(null, "Error al actualizar la nota");
            
        }

    }
    
    
    public void borrarInscripcion(int idAlumno, int idMateria){
        
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        
        try {
        
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            
                        
            int exito = ps.executeUpdate();
            
            if(exito > 0){
                JOptionPane.showMessageDialog(null, "Inscripcion borrada exitosamente!");
            }
            
            ps.close();
        
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al borrar inscripcion");
        
        }
        
    }
    
    
    
    public List <Inscripcion> obtenerInscripciones(){
        
        ArrayList<Inscripcion> cursadas = new ArrayList<>();
        
        String sql = "SELECT * FROM inscripcion";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                Inscripcion inscripcion = new Inscripcion();
                
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                
                Alumno pedro = ad.buscarAlumno(rs.getInt("idAlumno"));
                
                Materia lengua = md.buscarMateria(rs.getInt("idMateria"));
                
                inscripcion.setAlumno(pedro);
                inscripcion.setMateria(lengua);
                inscripcion.setNota(rs.getDouble("nota"));
                
                cursadas.add(inscripcion);

            }
            
            ps.close();
            
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "No se ha podido obtener la inscripcion");
        
        }
        
        return cursadas;
        
    }
    
    
        public List <Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
        
        ArrayList<Inscripcion> cursadas = new ArrayList<>();
        
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                Inscripcion inscripcion = new Inscripcion();
                
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                
                Alumno pedro = ad.buscarAlumno(rs.getInt("idAlumno"));
                
                Materia lengua = md.buscarMateria(rs.getInt("idMateria"));
                
                inscripcion.setAlumno(pedro);
                inscripcion.setMateria(lengua);
                inscripcion.setNota(rs.getDouble("nota"));
                
                cursadas.add(inscripcion);

            }
            
            ps.close();
            
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "No se ha podido hacer la inscripcion por alumno");
        
        }
        
        return cursadas;
        
    }
    
    
    
}
