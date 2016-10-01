/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sourcebossyear.servicio;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import sourcebossyear.dao.CategoriaCientificaDao;
import sourcebossyear.modelo.CategoriaCientifica;

/**
 *
 * @author Leydis & Eduardo
 */
@Service
public class CategoriaCientificaServicio {
    
    @Resource
    private CategoriaCientificaDao categoriaCientificaDao;

    public void salvar(CategoriaCientifica categoriaCientifica){
        this.categoriaCientificaDao.salvar(categoriaCientifica);
    }
    
    public List<CategoriaCientifica> getAll(){
        return this.categoriaCientificaDao.getAll();
    }
    
    public CategoriaCientifica get(Long id){
        return (CategoriaCientifica) this.categoriaCientificaDao.get(id);
    }
    
    public void actualizar(CategoriaCientifica categoriaCientifica){
        this.categoriaCientificaDao.actulizar(categoriaCientifica);
    }
    
    /**
     * @return the categoriaCientificaDao
     */
    public CategoriaCientificaDao getCategoriaCientificaDao() {
        return categoriaCientificaDao;
    }

    /**
     * @param categoriaCientificaDao the categoriaCientificaDao to set
     */
    public void setCategoriaCientificaDao(CategoriaCientificaDao categoriaCientificaDao) {
        this.categoriaCientificaDao = categoriaCientificaDao;
    }
}
