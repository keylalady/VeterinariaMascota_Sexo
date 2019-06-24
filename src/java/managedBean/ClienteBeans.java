/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.ClienteDao;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author USUARIOWIN10
 */
@ManagedBean
@ViewScoped
public class ClienteBeans {

    //private Date date9;
    private Cliente cliente;

    //constructor
    public ClienteBeans() {
        this.cliente = new Cliente();
    }
    private java.util.Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String guardarCliente() {
        ClienteDao clientedao = new ClienteDao();
        boolean respuesta = clientedao.guardarCliente(cliente);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/RegistroCliente";

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String actualizarCliente() {
        try {
            ClienteDao mascotadao = new ClienteDao();
            boolean resp = mascotadao.ActualizarMascota(cliente);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }
            mascotadao.ActualizarMascota(cliente);
        } catch (Exception e) {
            System.out.println("Error::" + e);
        }
        return "/RegistroCliente";
    }

    public ArrayList<Cliente> listarCliente() {
        ArrayList<Cliente> milista = new ArrayList<>();
        ClienteDao dao = new ClienteDao();
        milista = dao.listarCliente();
        return milista;

    }

    public String limpiar() {
        return "/RegistroCliente.xhtml";
    }

    public String eliminar(Cliente data) {
        ClienteDao madao = new ClienteDao();
        boolean respuesta = madao.eliminarMascota(data);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }

        return "/RegistroCliente.xhtml";
    }
}
