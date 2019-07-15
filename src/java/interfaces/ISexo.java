/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Sexo;
import java.util.ArrayList;

/**
 *
 * @author USUARIOWIN10
 */
public interface ISexo {

    public abstract boolean guardarSexo(Sexo sexo);

    public abstract ArrayList<Sexo> listarSexo();

    public abstract boolean ActualizarSexo(Sexo sexo);

    public abstract boolean eliminarSexo(Sexo sexo);

}
