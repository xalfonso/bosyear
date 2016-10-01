/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sourcebossyear.servicio;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import sourcebossyear.dao.TipoActividadDao;
import sourcebossyear.modelo.TipoActividad;

/**
 *
 * @author Leydis & Eduardo
 */
@Service
public class TipoActividadServicio {
    
    @Resource
    private TipoActividadDao tipoActividadDao;
    
    
    public void salvar(TipoActividad tipoActividad){
        this.tipoActividadDao.salvar(tipoActividad);
    }
    
    public List<TipoActividad> getAll(){
        return this.tipoActividadDao.getAll();
    }
    
    public TipoActividad get(Long id){
        return (TipoActividad) this.tipoActividadDao.get(id);
    }
    
    public void actualizar(TipoActividad tipoActividad){
        this.tipoActividadDao.actulizar(tipoActividad);
    }
    /**
     * @return the tipoActividadDao
     */
    public TipoActividadDao getTipoActividadDao() {
        return tipoActividadDao;
    }

    /**
     * @param tipoActividadDao the tipoActividadDao to set
     */
    public void setTipoActividadDao(TipoActividadDao tipoActividadDao) {
        this.tipoActividadDao = tipoActividadDao;
    }
}
