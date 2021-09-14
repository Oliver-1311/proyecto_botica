package controler;
/**** @author Msc. Ing. Miguel Angel Silva Zapata*/
import java.awt.Image;
import javax.swing.*;import java.sql.*;
import javax.swing.table.*;
public class Controlador {
    public static Conexion Base = new Conexion();    
    public void LlenarCombo(JComboBox cbo, String Consulta, int pos) {
     cbo.removeAllItems();try {Base.rt = DevolverRegistro(Consulta);
     cbo.addItem("<Seleccionar>");
     while (Base.rt.next()) {cbo.addItem(Base.rt.getString(pos));}
     cbo.setSelectedIndex(-1);} catch (Exception e) {e.printStackTrace();}
    }    
    public ResultSet DevolverRegistro(String sq) {
     try {Base.st = Base.conec.createStatement();Base.rt = 
     Base.st.executeQuery(sq);} 
     catch (Exception e) {e.printStackTrace();}return Base.rt;
    }    
    public String DevolverRegistroDto(String sq, int pos) {
     String rs = "";
     try {
       Base.st = Base.conec.createStatement();Base.rt = Base.st.executeQuery(sq);
       if (Base.rt.next()) rs = Base.rt.getString(pos);            
       
      } catch (Exception e) {e.printStackTrace();}
      return rs;
    }        
    public boolean Verificarconsulta(String sql) {
     boolean bd = false;try {Base.st = Base.conec.createStatement();
     Base.rt = Base.st.executeQuery(sql);
     bd = Base.rt.next();}catch (Exception e) {} return bd;
    }
    public void ActualizarRegistro(String sq) {
      try {Base.st = Base.conec.createStatement();
      Base.st.executeUpdate(sq);} 
      catch (Exception e) {e.printStackTrace();}
    }        
    public void LimTabla(DefaultTableModel mdl) {
     while (mdl.getRowCount() > 0)mdl.removeRow(0);        
    }
    public void LlenarJTabla(DefaultTableModel mdl, String sq, int cdt) {
     LimTabla(mdl);String Data[]=new String[20];
     try {
      Base.st = Base.conec.createStatement();
      Base.rt = Base.st.executeQuery(sq);
      while (Base.rt.next()) {
       for (int i = 1; i <= cdt; i++) {
        Data[i - 1] = Base.rt.getString(i);
       }mdl.addRow(Data);
      }
     } catch (Exception e) {e.printStackTrace();}
   }
    
    
}
