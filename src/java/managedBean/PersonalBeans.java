/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.PersonalDao;
import entidades.Personal;
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
public class PersonalBeans {

    private Personal personal;

    /**
     * Creates a new instance of PersonalBean
     */
    //constructor
    public PersonalBeans() {
        this.personal = new Personal();
    }

    public String guardarPersonal() {
        PersonalDao dao = new PersonalDao();
        boolean respuesta = dao.guardarPersonal(personal);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/RegistroPersonal";

    }

    public String actualizarPersonal() {
        try {
            PersonalDao personaldao = new PersonalDao();
            boolean resp = personaldao.ActualizarPersonal(personal);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }
            personaldao.ActualizarPersonal(personal);
        } catch (Exception e) {
            System.out.println("Error::"+e);
        }
        return "/RegistroPersonal";
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public ArrayList<Personal> listarPersonal() {
        ArrayList<Personal> milista = new ArrayList<>();
        PersonalDao dao = new PersonalDao();
        milista = dao.listarPersonal();
        return milista;

    }

    public String limpiar() {
        return "/RegistroPersonal.xhtml";
    }

    public String eliminar(Personal data) {
        PersonalDao madao = new PersonalDao();
        boolean respuesta = madao.eliminarPersonal(data);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }

        return "/RegistroPersonal.xhtml";
    }
}
