/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sourcebossyear.servicio;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import sourcebossyear.dao.MedioDao;
import sourcebossyear.modelo.Medio;

/**
 *
 * @author Leydis & Eduardo
 */
@Service
public class MedioServicio {
    
    @Resource
    private MedioDao medioDao;

    
    public void salvar(Medio medio){
        this.medioDao.salvar(medio);
    }
    
    public List<Medio> getAll(){
        return this.medioDao.getAll();
    }
    
    public Medio get(Long id){
        return (Medio) this.medioDao.get(id);
    }
    
    public void actualizar(Medio medio){
        this.medioDao.actulizar(medio);
    }
    
    /**
     * @return the medioDao
     */
    public MedioDao getMedioDao() {
        return medioDao;
    }

    /**
     * @param medioDao the medioDao to set
     */
    public void setMedioDao(MedioDao medioDao) {
        this.medioDao = medioDao;
    }
}
