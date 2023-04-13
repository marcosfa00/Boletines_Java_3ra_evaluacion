/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin28;

import javax.swing.*;

/**
 *
 * @author marcosfa
 */
public class Layout {
    
    //componentes
    JFrame frame;
    JPanel panel1,panel2;
    JButton button1,button2;
    JTextField txt1,txt2;
    JLabel label1,label2;
    JTextArea txta;
    
    public void iniciarComponentes(){
     frame = new JFrame("******BOLETIN 28*****");
     panel1 = new JPanel();
     panel2 = new JPanel();
     button1 = new JButton("PREMER");
     button2 = new JButton("LIMPAR");
     txt1 =  new JTextField();
     txt2 =  new JTextField();
     label1 = new JLabel("NOMBRE:");
     label2 = new JLabel("PASSWORD:");
     txta =  new JTextArea("AREA DE TEXTO.");
     
     frame.setSize(550, 550);
    
    }
    
    public void mostrar(){
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(frame);
        frame.setVisible(true);
    }
    
    public JPanel add(JPanel panel){
        panel.add(label1);
        panel.add(label2);
        panel.add(button1);
        panel.add(button2);
        panel.add(txt1);
        panel.add(txt2);
        panel.add(txta);
        return panel;
    }
    
    public void setLayout(){
        //inicializamos los componenetes
        iniciarComponentes();
        
        //FORMATEAMOS EL LAYOUT DEL PANEL
        panel1.setLayout(null);
        //editamos la posicion de los mismos
        
        label1.setBounds(50,50,100,50);
        txt1.setBounds(150,50,300,50);
         label2.setBounds(50,130,100,50);
        txt2.setBounds(150,130,300,50);
        
        txta.setBounds(110, 200, 350, 150);
        
        button1.setBounds(100, 400, 100, 40);
        button2.setBounds(350, 400, 100, 40);
        
       
        
        //añadimos todo al jframe
         panel1 = add(panel1);
        frame.add(panel1);
        //mostramos la ventana
        mostrar();
    }
    
    
}
