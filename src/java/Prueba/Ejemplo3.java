/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Dao.MascotaDao;
import entidades.Mascota;
import javax.servlet.jsp.PageContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author USUARIOWIN10
 */
public class Ejemplo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        MascotaDao mascotadao = new MascotaDao();
        Mascota mimascota = new Mascota(2, "keyla", "carlos", "Pastor Aleman");
        mascotadao.ActualizarMascota(mimascota);
        sesion.beginTransaction();
       sesion.saveOrUpdate(mimascota);
        sesion.getTransaction().commit();
        sesion.close();

    }

}
