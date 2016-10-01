/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sourcebossyear.servicio;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import sourcebossyear.dao.SemanaP1Dao;
import sourcebossyear.modelo.Local;
import sourcebossyear.modelo.SemanaP1;

/**
 *
 * @author Leydis & Eduardo
 */
@Service
public class SemanaP1Servicio {
    
    @Resource
    private SemanaP1Dao semanaP1Dao;

    public void salvar(SemanaP1 semanaP1){
        this.semanaP1Dao.salvar(semanaP1);
    }
    
    public List<SemanaP1> getAll(){
        return this.semanaP1Dao.getAll();
    }
    
    public SemanaP1 get(Long id){
        return (SemanaP1) this.semanaP1Dao.get(id);
    }
    
    public void actualizar(SemanaP1 semanaP1){
        this.semanaP1Dao.actulizar(semanaP1);
    }
    
    
    /**
     * @return the semanaP1Dao
     */
    public SemanaP1Dao getSemanaP1Dao() {
        return semanaP1Dao;
    }

    /**
     * @param semanaP1Dao the semanaP1Dao to set
     */
    public void setSemanaP1Dao(SemanaP1Dao semanaP1Dao) {
        this.semanaP1Dao = semanaP1Dao;
    }
    
    
    
}
