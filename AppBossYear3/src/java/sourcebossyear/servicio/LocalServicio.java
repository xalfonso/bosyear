/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sourcebossyear.servicio;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import sourcebossyear.dao.LocalDao;
import sourcebossyear.modelo.Local;

/**
 *
 * @author Leydis & Eduardo
 */
@Service
public class LocalServicio {
    
    @Resource
    private LocalDao localDao;
    
    public void salvar(Local local){
        this.localDao.salvar(local);
    }
    
    public List<Local> getAll(){
        return this.localDao.getAll();
    }
    
    public Local get(Long id){
        return (Local) this.localDao.get(id);
    }
    
    public void actualizar(Local local){
        this.localDao.actulizar(local);
    }
    
    

    /**
     * @return the localDao
     */
    public LocalDao getLocalDao() {
        return localDao;
    }

    /**
     * @param localDao the localDao to set
     */
    public void setLocalDao(LocalDao localDao) {
        this.localDao = localDao;
    }
}
