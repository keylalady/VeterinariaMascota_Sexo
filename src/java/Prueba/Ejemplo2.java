/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Dao.MascotaDao;
import entidades.Mascota;

/**
 *
 * @author USUARIOWIN10
 */
public class Ejemplo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MascotaDao mascotadao = new MascotaDao();
        Mascota mimascota = new Mascota(7, "Sandor", "fidel", "Terriers");
        mascotadao.guardarMascota(mimascota);
    }
    
}
