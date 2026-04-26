/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.Recurso;

/**
 *
 * @author moral
 */
public interface RecursoRepository {
   void InsertarRecurso(Recurso recurso);
   boolean EditarRecurso(Recurso recurso);
   boolean EliminarRecurso(Recurso recurso);
   boolean BusquedaIDRecurso(Recurso recurso);
   void ListaRecurso();
   
}
