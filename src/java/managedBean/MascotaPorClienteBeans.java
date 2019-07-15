/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.ClienteDao;
import Dao.MascotaDao;
import Dao.MascotaporclienteDao;
import entidades.Mascota;
import entidades.Mascotaporcliente;
import entidades.MascotaporclienteId;
import java.util.ArrayList;
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
public class MascotaPorClienteBeans {

    
    private boolean banderaSelect = false;
    private ArrayList listaclientes;
    private ArrayList listamascota;

    private int idCliente;
    private int idMascota;

    private Mascotaporcliente MascotaPorCliente;
    private MascotaporclienteId mascotaporclienteid;
    //Contructor
    public MascotaPorClienteBeans() {
        listaclientes = new ArrayList();
        MascotaPorCliente = new Mascotaporcliente();
        mascotaporclienteid = new MascotaporclienteId();
        listarCombos();

    }

    public void listarCombos() {
        ClienteDao clientedao = new ClienteDao();
        MascotaDao mascotadao = new MascotaDao();
        listaclientes = clientedao.listarCliente();
        listamascota = mascotadao.listarMascotas();

    }

    public String guardarMascotaPorCliente() {
        MascotaporclienteDao dao = new MascotaporclienteDao();
        
        mascotaporclienteid.setClienteIdcliente(idCliente);
        mascotaporclienteid.setMascotaIdMascota(idMascota);
        
        MascotaPorCliente.setId(mascotaporclienteid);
       dao.guardarMascotaPorCliente(MascotaPorCliente);
       
        return "/RegistroMascotaPorCliente";

    }

    public ArrayList getListacliente() {
        return listaclientes;
    }

    public void setListacliente(ArrayList listaclientes) {
        this.listaclientes = listaclientes;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList getListamascota() {
        return listamascota;
    }

    public void setListamascota(ArrayList listamascota) {
        this.listamascota = listamascota;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public Mascotaporcliente getMascotaPorCliente() {
        return MascotaPorCliente;
    }

    public void setMascotaPorCliente(Mascotaporcliente MascotaPorCliente) {
        this.MascotaPorCliente = MascotaPorCliente;
    }

    public void selectBandera() {
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

}
