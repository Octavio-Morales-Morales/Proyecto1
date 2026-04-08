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
   
    java.awt.EventQueue.invokeLater(() -> {
            EntradaPantalla inicial = new EntradaPantalla();
            inicial.setVisible(true);
            inicial.setLocationRelativeTo(null); // La centra en la pantalla
        });
}}
