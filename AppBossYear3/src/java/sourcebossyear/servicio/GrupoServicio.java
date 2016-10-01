/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sourcebossyear.servicio;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import sourcebossyear.dao.GrupoDao;
import sourcebossyear.modelo.Grupo;

/**
 *
 * @author Leydis & Eduardo
 */
@Service
public class GrupoServicio {

    @Resource
    private GrupoDao grupoDao;

    
    public void salvar(Grupo grupo){
        this.grupoDao.salvar(grupo);
    }
    
    public List<Grupo> getAll(){
        return this.grupoDao.getAll();
    }
    
    public Grupo get(Long id){
        return (Grupo) this.grupoDao.get(id);
    }
    
    public void actualizar(Grupo grupo){
        this.grupoDao.actulizar(grupo);
    }
    /**
     * @return the grupoDao
     */
    public GrupoDao getGrupoDao() {
        return grupoDao;
    }

    /**
     * @param grupoDao the grupoDao to set
     */
    public void setGrupoDao(GrupoDao grupoDao) {
        this.grupoDao = grupoDao;
    }

}
