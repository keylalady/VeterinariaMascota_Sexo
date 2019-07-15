/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.SexoDao;
import entidades.Sexo;
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
public class SexoBeans {

    //private Date date9;
    private Sexo sexo;
     private boolean banderaSelect = false;

    //constructor
    public SexoBeans() {
        this.sexo = new Sexo();
    }
    private java.util.Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String guardarSexo() {
        SexoDao sexodao = new SexoDao();
        boolean respuesta = sexodao.guardarSexo(sexo);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/RegistroSexo";

    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String actualizarSexo() {
        try {
            SexoDao mascotadao = new SexoDao();
            boolean resp = mascotadao.ActualizarSexo(sexo);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }
            mascotadao.ActualizarSexo(sexo);
        } catch (Exception e) {
            System.out.println("Error::" + e);
        }
        return "/RegistroSexo";
    }

    public ArrayList<Sexo> listarSexo() {
        ArrayList<Sexo> milista = new ArrayList<>();
        SexoDao dao = new SexoDao();
        milista = dao.listarSexo();
        return milista;

    }

    public String limpiar() {
        banderaSelect=false;
        return "/RegistroSexo.xhtml";
    }

    public String eliminar(Sexo data) {
        SexoDao madao = new SexoDao();
        boolean respuesta = madao.eliminarSexo(data);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }

        return "/RegistroSexo.xhtml";
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
