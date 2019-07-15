/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Mascota;
import interfaces.IMascota;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import utilitarios.HibernateUtil;

/**
 *
 * @author USUARIOWIN10
 */
public class MascotaDao implements IMascota {

    @Override
    public boolean guardarMascota(Mascota mascota) {
        //Construir una nueva session y una nueva transaccion
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //Rgistrar en la base de datos la mascota

        try {
            sesion.save(mascota);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("ERROR DE GUARFDAR::" + e);
            respuesta = false;
        }

        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Mascota> listarMascotas() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Mascota> milista = new ArrayList<>();
        //Create la consulta hacia la base de datos
        Query query = sesion.createQuery("from Mascota");
        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Mascota>) query.list();
          sesion.close();
        return milista;
    
       
    }

    @Override
    public boolean ActualizarMascota(Mascota mascota) {
        System.out.println("error"+ mascota.getNombreCliente());
        boolean resp= true;
        Session sesion= null;
        try {
            sesion=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=sesion.beginTransaction();
            sesion.update(mascota);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error en actualizar::"+e);
        }finally{
            if(sesion != null){
                sesion.close();
            }
            
        }
       return resp;
    }

    @Override
    public ArrayList<Mascota> listarMascotasRaza(Session sesion) {
        String hql = " from Mascota where raza='Pastor Aleman'";
        Query query = sesion.createQuery(hql);
        List< Mascota> lista = (List< Mascota>) query.list();
        return (ArrayList<Mascota>) lista;

    }

    @Override
    public ArrayList<Mascota> listarMascotasNombre(Session sesion) {
        String hql = " from Mascota where nombreMascota='Sandor'";
        Query query = sesion.createQuery(hql);
        List< Mascota> lista = (List< Mascota>) query.list();
        return (ArrayList<Mascota>) lista;

    }

    @Override
    public Integer Contar(Session sesion) {
        String hql = "select count(*) from Mascota";
        Query query = sesion.createQuery(hql);
        Long FilasTab = (Long) query.uniqueResult();
        Integer cont = FilasTab.intValue();
        return cont;

    }

    @Override
    public boolean eliminarMascota(Mascota mascota) {
        Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(mascota);
            sesion.getTransaction().commit();

        } catch (Exception e) {
            resp = false;
            System.out.println("ERROR EN ELIMINAR::" + e);
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();

            }

        }
        return resp;
    }
}
