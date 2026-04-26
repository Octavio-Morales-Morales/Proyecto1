/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.Espacio;

/**
 *
 * @author moral
 */
public interface EspacioRepository {
    void InsertarEspacio(Espacio espacio);
    boolean EditarEspacio(Espacio espacio);
    boolean EliminarEspacio(Espacio espacio);
    boolean BusquedaIDEspacio(Espacio espacio);
    void ListaEspacios();
    
}
