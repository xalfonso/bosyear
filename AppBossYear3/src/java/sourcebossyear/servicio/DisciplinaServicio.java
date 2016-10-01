/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sourcebossyear.servicio;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import sourcebossyear.dao.DisciplinaDao;
import sourcebossyear.modelo.Disciplina;

/**
 *
 * @author Leydis & Eduardo
 */
@Service
public class DisciplinaServicio {
    
    @Resource
    private DisciplinaDao disciplinaDao;

    public void salvar(Disciplina disciplina){
        this.disciplinaDao.salvar(disciplina);
    }
    
    public List<Disciplina> getAll(){
        return this.disciplinaDao.getAll();
    }
    
    public Disciplina get(Long id){
        return (Disciplina) this.disciplinaDao.get(id);
    }
    
    public void actualizar(Disciplina disciplina){
        this.disciplinaDao.actulizar(disciplina);
    }
    
    
    /**
     * @return the disciplinaDao
     */
    public DisciplinaDao getDisciplinaDao() {
        return disciplinaDao;
    }

    /**
     * @param disciplinaDao the disciplinaDao to set
     */
    public void setDisciplinaDao(DisciplinaDao disciplinaDao) {
        this.disciplinaDao = disciplinaDao;
    }
}
