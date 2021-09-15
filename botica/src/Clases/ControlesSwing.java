/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author User
 */
//import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.JTextComponent;

public class ControlesSwing {
  boolean bdr=false;  
 
 public void VerEnCboCaracdeCadena(JComboBox cb,String cdn){
  cb.removeAllItems();
  for(int p=0;p<cdn.length();p++){
   cb.addItem(cdn.charAt(p));
  }   
  cb.setSelectedIndex(-1);
 }
 public boolean ExiteenCombo(JComboBox cbo,String dto){
  bdr=false;
  for(int p=0;p<cbo.getModel().getSize();p++){
   if(cbo.getModel().getElementAt(p).toString().equalsIgnoreCase(dto)){
    bdr=true;break;
   }         
  }
  return bdr;
 }
 public void setWidthTableColumn(JTable table, int width, int... indexs) {
  for (int j : indexs) {
   table.getColumnModel().getColumn(j).setWidth(width);
   table.getColumnModel().getColumn(j).setPreferredWidth(width);
  }
 }
 public int BuscarDatoenJtable(DefaultTableModel md, String dto, int col) {
  int pos = -1;
  if (md.getRowCount() > 0) {
   for(int fil=0;fil<md.getRowCount();fil++){
    if (md.getValueAt(fil, col).toString().equalsIgnoreCase(dto)){pos=fil;break;}   
   }     
  }
  return pos;
 }
 
 public void hideTableColumn(JTable table, int... indexs) {
  for (int j : indexs) {
   table.getColumnModel().getColumn(j).setMinWidth(0);
   table.getColumnModel().getColumn(j).setPreferredWidth(0);
   table.getColumnModel().getColumn(j).setWidth(0);
   table.getColumnModel().getColumn(j).setMaxWidth(-1);
  }
 }
 
 public void MostrarElemCboenTxt(JComboBox cb,JTextField tx){
  if(cb.getSelectedIndex()>-1){
   tx.setText((String)cb.getSelectedItem());
  }   
 } 
 public String PrmLetras(String cdn){
  String ltrs=""+cdn.charAt(0);   
  for(int f=0;f<cdn.length();f++){
   if(cdn.charAt(f)==' '){
    ltrs=ltrs+cdn.charAt(f+1);
   }   
  }   
  return ltrs;
 }
 public String  GenerCodigo(String apnom,DefaultTableModel mdtb){
  int ctd=(mdtb.getRowCount()+1);   
  String cod=PrmLetras(apnom)+"_"+ctd;
  boolean bra=ComprobRepdtoEnJtable(mdtb,cod,0);
  while (bra) {         
    ctd++;cod=PrmLetras(apnom)+"_"+ctd;      
    bra=ComprobRepdtoEnJtable(mdtb,cod,0);
  }  
  return cod;
 }
 public void SelecionaTexto(JTextField txt){
  txt.setSelectionStart(0);txt.setSelectionEnd(txt.getText().length());   
 }
 public void AgregadeTxtaCombo(JTextField tx,JComboBox cb){
  if(tx.getText().trim().length()==0){
   JOptionPane.showMessageDialog(null, "Debes Ingresar un Dato");
  }
  else{     
    if (ExiteenCombo(cb, tx.getText())) {
     JOptionPane.showMessageDialog(null, "El dato: "+tx.getText()+"\n Ya Existe");
     SelecionaTexto(tx);
    }
    else{
     cb.addItem(tx.getText());cb.setSelectedIndex(-1);tx.setText("");   
    }   
  }
  tx.grabFocus();
 }
 
 public void AgregadeTxtaLista(JTextField tx,DefaultListModel mdl){
  if(tx.getText().trim().length()==0){
   JOptionPane.showMessageDialog(null, "Debes Ingresar un Dato");
  }
  else{
   if(ExiteenLista(mdl,tx.getText())==-1){
    mdl.addElement(tx.getText());tx.setText("");       
   }   
   else{
    JOptionPane.showMessageDialog(null, "El dato "+tx.getText()
    +"\n Ya existe en la Lista");SelecionaTexto(tx);
   }    
  }
  tx.grabFocus();
 }
 static public boolean ExiteenCombo2(JComboBox cbo,String dto){
  boolean br=false;
  for(int p=0;p<cbo.getModel().getSize();p++){
   if(cbo.getModel().getElementAt(p).toString().equalsIgnoreCase(dto)){
    br=true;break;
   }         
  }
  return br;
 } 
 //implemente un programa que le permita a traves de un formulario
 // que cuenta con una caja de texto, una lista desplegable y dos 
 //botones de comando le permita ingresar un numero y que al presionar enter 
 // sobre la caja de texto ese numero se agregue a lista desplegable
 // siempre y cuando el numero no se repita, con el primer boton de comando
 // debe poder limpiar los controles tanto la caja como el combo
 // y con el segundo boton se debe poder salir de la aplicacion o programa.
 //Trabaje con enfoque de POO.
 static public int ExiteenCombo1(JComboBox cbo,String dto){
  int ps=-1;
  for(int p=0;p<cbo.getModel().getSize();p++){
   if(cbo.getModel().getElementAt(p).toString().equalsIgnoreCase(dto)){
    ps=p;break;   
   }         
  }
  return ps;
 }
 
 public void Sel_Exit_Combo(JComboBox cbo,String dto){  
  cbo.setSelectedIndex(ExiteenCombo1(cbo,dto));
 }
 static public int ExiteenLista(DefaultListModel dlt,String dto){
  int ps=-1;
  for(int p=0;p<dlt.getSize();p++){
   if(dlt.getElementAt(p).toString().equalsIgnoreCase(dto)){
    ps=p;break;   
   }         
  }
  return ps;
 }
 public String Formato_Amd(java.util.Date v1) {
  Date fecha1 = v1;SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
  String fecha = df.format(fecha1);return fecha;
 }
 public String Formato_DMA(java.util.Date v1) {
  Date fecha1 = v1;SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
  String fecha = df.format(fecha1);
  return fecha;
 }

 
 static public int ExiteenListaeach(DefaultListModel dlt,String dto){
  int ps=-1;
  
  /*for(int p=0;p<dlt.getSize();p++){
   if(dlt.getElementAt(p).toString().equalsIgnoreCase(dto)){
    ps=p;break;   
   }         
  }*/
  
  return ps;
 }
 public void LimpiarJTable(DefaultTableModel mdt){
  while(mdt.getRowCount()>0)
   mdt.removeRow(0);
 }
 public boolean ComprobRepdtoEnJtable(DefaultTableModel mdtb,
 String dto,int clbsc){boolean bd=false;
   for(int f=0;f<mdtb.getRowCount();f++){
    if(mdtb.getValueAt(f,clbsc).toString().equalsIgnoreCase(dto)){
      bd=true;break;
    }    
   }
   return bd;
  }
 public String SumadeunaColumna(DefaultTableModel mdtb,int col){
 Double ctd=0.00;
  for(int f=0;f<mdtb.getRowCount();f++){
   ctd=ctd+Double.parseDouble(mdtb.getValueAt(f, col).toString());
  }
  return Double.toString(ctd);
 }
 public void Volvetxtatx(JTextField txt){
  if(txt.getText().trim().length()==0)
   txt.grabFocus();
 }
}
