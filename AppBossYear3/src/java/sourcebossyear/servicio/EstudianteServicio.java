/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sourcebossyear.servicio;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import sourcebossyear.dao.EstudianteDao;
import sourcebossyear.modelo.Estudiante;

/**
 *
 * @author Leydis & Eduardo
 */
@Service
public class EstudianteServicio {
    
    @Resource
    private EstudianteDao estudianteDao;
    
    public void salvar(Estudiante estudiante){
        this.estudianteDao.salvar(estudiante);
    }
    
    public List<Estudiante> getAll(){
        return this.estudianteDao.getAll();
    }
    
    public Estudiante get(Long id){
        return (Estudiante) this.estudianteDao.get(id);
    }
    
    public void actualizar(Estudiante estudiante){
        this.estudianteDao.actulizar(estudiante);
    }

    /**
     * @return the estudianteDao
     */
    public EstudianteDao getEstudianteDao() {
        return estudianteDao;
    }

    /**
     * @param estudianteDao the estudianteDao to set
     */
    public void setEstudianteDao(EstudianteDao estudianteDao) {
        this.estudianteDao = estudianteDao;
    }
}
