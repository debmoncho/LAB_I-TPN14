
package AccesoADatos;

import entidades.Materia;
import java.sql.*;
import javax.swing.JOptionPane;


public class MateriaData {
    
    private Connection con = null;

    public MateriaData() {

        con = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia) {
    
    String sql = "INSERT INTO materia(nombre, año, estado) "
            + "VALUES (?,?,?)";
    
    try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia Guardada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar la materia");
        }
    }
    
    public void modificarMateria(Materia materia) {

        String sql = "UPDATE materia SET nombre = ?, año = ?,estado = ? "
                + "WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.setInt(4, materia.getIdMateria());
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia modificada");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la materia");
        }
    }
    
    public void eliminarMateria(int id) {

        String sql = "UPDATE materia SET estado= 0  WHERE idMateria= ? ";

        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia Eliminada");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la materia");
        }
    }
    
}



