/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Dao.MascotaDao;
import entidades.Mascota;
import java.util.ArrayList;
import org.hibernate.Session;
import utilitarios.HibernateUtil;

/**
 *
 * @author USUARIOWIN10
 */
public class Ejemplo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ArrayList<Mascota> lista = new ArrayList<>();

        MascotaDao mascotadao = new MascotaDao();

        Session sesion = HibernateUtil.getSessionFactory().openSession();

        lista = mascotadao.listarMascotasNombre(sesion);
        System.out.println("ID\t"+"NOMBRE MASCOTA\t"+"NOMBRE CLIENTE\t"+"RAZA");
        for (Mascota mascota : lista) {
                        
            System.out.println(mascota.getIdMascota() + "\t"+mascota.getNombreMascota()+"\t \t"+mascota.getNombreCliente()+"\t \t"+mascota.getRaza());
           
        }
    }
    
}
