/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Dao.MascotaDao;
import entidades.Mascota;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import utilitarios.HibernateUtil;

/**
 *
 * @author USUARIOWIN10
 */
public class Ejemplo7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cont;
        MascotaDao mascotadao = new MascotaDao();

        Session sesion = HibernateUtil.getSessionFactory().openSession();

        cont = mascotadao.Contar(sesion);
       JOptionPane.showMessageDialog(null, "cantidad de registro : " +cont);

       // System.out.println("cantidad de registro :" + cont);

    }

}
