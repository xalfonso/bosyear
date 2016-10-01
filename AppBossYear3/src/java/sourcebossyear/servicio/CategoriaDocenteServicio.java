/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sourcebossyear.servicio;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import sourcebossyear.dao.CategoriaDocenteDao;
import sourcebossyear.modelo.CategoriaDocente;

/**
 *
 * @author Leydis & Eduardo
 */
@Service
public class CategoriaDocenteServicio {
    
    @Resource
    private CategoriaDocenteDao categoriaDocenteDao;

    public void salvar(CategoriaDocente categoriaDocente){
        this.categoriaDocenteDao.salvar(categoriaDocente);
    }
    
    public List<CategoriaDocente> getAll(){
        return this.categoriaDocenteDao.getAll();
    }
    
    public CategoriaDocente get(Long id){
        return (CategoriaDocente) this.categoriaDocenteDao.get(id);
    }
    
    public void actualizar(CategoriaDocente categoriaDocente){
        this.categoriaDocenteDao.actulizar(categoriaDocente);
    }
    
    /**
     * @return the categoriaDocenteDao
     */
    public CategoriaDocenteDao getCategoriaDocenteDao() {
        return categoriaDocenteDao;
    }

    /**
     * @param categoriaDocenteDao the categoriaDocenteDao to set
     */
    public void setCategoriaDocenteDao(CategoriaDocenteDao categoriaDocenteDao) {
        this.categoriaDocenteDao = categoriaDocenteDao;
    }
}
