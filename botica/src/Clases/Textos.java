/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/****** @author User *********/
public class Textos {    
 static public void Mayusculas(KeyEvent e){
  if(Character.isLowerCase(e.getKeyChar()))      
   e.setKeyChar((""+e.getKeyChar()).toUpperCase().charAt(0));    
 }    
 static public void Numeros(KeyEvent e){
  if(!Character.isDigit(e.getKeyChar())) e.consume();      
 }
 static public String Vocales(String cade){
  String base="a,e,i,o,u",res="";     
  for (char c: cade.toLowerCase().toCharArray ()) {if(base.indexOf(c)>-1) res=res+c;}
  return res;
 }
 static public void Decimal(KeyEvent e, JTextField tx){
  char caracter = e.getKeyChar();   
  if((tx.getText().length()==0)&& (caracter=='.'))  e.consume();  
  else{
   if (((caracter < '0') || (caracter > '9')) 
    && (caracter != KeyEvent.VK_BACK_SPACE)
    && (caracter != '.' || tx.getText().contains("."))) {e.consume();}     
  }    
 }
 static public void MarcarTexto(JTextField tx){
   tx.setSelectionStart(0);tx.setSelectionEnd(tx.getText().length());tx.grabFocus();  
 }
 static public void VolverTexto(JTextField tx){
     if(tx.getText().trim().length()==0)
         tx.requestFocus();
 }
}
