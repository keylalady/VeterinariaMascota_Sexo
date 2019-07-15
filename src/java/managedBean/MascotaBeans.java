/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.MascotaDao;
import entidades.Mascota;
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
public class MascotaBeans {

    private Mascota mascota;
    private boolean banderaSelect = false;

    //constructor
    public MascotaBeans() {
        this.mascota = new Mascota();
    }

    public String guardarMascota() {
        MascotaDao dao = new MascotaDao();
        boolean respuesta = dao.guardarMascota(mascota);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/index";

    }

    public String actualizarMascota() {
        try {
            MascotaDao mascotadao = new MascotaDao();
            boolean resp = mascotadao.ActualizarMascota(mascota);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }
            mascotadao.ActualizarMascota(mascota);
        } catch (Exception e) {
            System.out.println("Error::" + e);
        }
        return "/index";
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public ArrayList<Mascota> listarMascota() {
        ArrayList<Mascota> milista = new ArrayList<>();
        MascotaDao dao = new MascotaDao();
        milista = dao.listarMascotas();
        return milista;

    }

    public String limpiar() {
        banderaSelect=false;
        return "/index.xhtml";
    }

    public String eliminar(Mascota data) {
        MascotaDao madao = new MascotaDao();
        boolean respuesta = madao.eliminarMascota(data);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }

        return "/index.xhtml";
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
