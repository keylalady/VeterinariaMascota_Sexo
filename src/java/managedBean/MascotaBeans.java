/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.MascotaDao;
import entidades.Mascota;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author USUARIOWIN10
 */
@ManagedBean
@ViewScoped
public class MascotaBeans {

    private Mascota mascota;

    /**
     * Creates a new instance of MascotaBean
     */
    //constructor
    public MascotaBeans() {
        this.mascota = new Mascota();
    }

    public void guardarMascota() {
        try {
            MascotaDao mascotadao = new MascotaDao();
            mascotadao.guardarMascota(mascota);

        } catch (Exception e) {
            System.out.println("error" + e);
            
        }
        
    }

    public boolean actualizarMascota(Mascota mascota) {

        boolean respuesta = true;
        try {
            MascotaDao mascotadao = new MascotaDao();
            mascotadao.ActualizarMascota(mascota);
        } catch (Exception e) {
            respuesta = false;
        }
        return respuesta;
    }

    /* public ArrayList<Mascota> listarMascotas() {
   
        boolean respuesta = true;
        try {
            ArrayList<Mascota> lista = new ArrayList<>();
            MascotaDao mascotadao = new MascotaDao();
            lista = mascotadao.listarMascotas(session);
            return lista;
        } catch (Exception e) {
            respuesta = false;
        }
     //  return respuesta;
}*/

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
  public ArrayList<Mascota> listarMascota(){
      ArrayList<Mascota>milista = new ArrayList<>();
      MascotaDao dao= new MascotaDao();
     milista= dao.listarMascotas();
     return milista;
      
  }
  public String limpiar(){
      return "/index.xhtml";
  }
}
