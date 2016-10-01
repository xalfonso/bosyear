/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sourcebossyear.dao;

import java.util.List;



/**
 *
 * @author Leydis & Eduardo
 */
public interface DaoGenerico {    

    public void salvar(Object object);
    public void actulizar(Object object);
    public void eliminar(Object object);
    public Object get(Long id);
    public List getAll();
    
}
