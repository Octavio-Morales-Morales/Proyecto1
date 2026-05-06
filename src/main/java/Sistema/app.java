/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Sistema;
import IG.EntradaPantalla; 

/**
 *
 * @author moral
 */
public class app {

    public static void main(String[] args) {
   // Pantalla de Loggin
    java.awt.EventQueue.invokeLater(() -> {
            EntradaPantalla inicial = new EntradaPantalla();
            inicial.setVisible(true);
            inicial.setLocationRelativeTo(null); 
        });
}}
