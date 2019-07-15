/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import entidades.Mascota;
import entidades.Mascotaporcliente;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author USUARIOWIN10
 */
public interface IMascotaporcliente {

    public abstract boolean guardarMascotaPorCliente(Mascotaporcliente mascotaporcliente);
    public abstract ArrayList<Mascotaporcliente> listarMascotaPorCliente();
     public abstract boolean ActualizarMascotaPorCliente(Mascotaporcliente mascotaporcliente);
     public abstract boolean eliminarMascotaPorCliente(Mascotaporcliente mascotaporcliente);

    
    
}
