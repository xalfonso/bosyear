/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sourcebossyear.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import sourcebossyear.modelo.CategoriaDocente;

/**
 *
 * @author Leydis & Eduardo
 */
@Repository
public class CategoriaDocenteDao implements DaoGenerico{

    @Resource
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void salvar(Object object) {
        CategoriaDocente categoriaDocente = (CategoriaDocente) object;
        this.getJdbcTemplate().update("insert into categoriadocente(nombre) values(?)", categoriaDocente.getNombre());
    }

    @Override
    public void actulizar(Object object) {
        CategoriaDocente categoriaDocente = (CategoriaDocente) object;
        this.jdbcTemplate.update("UPDATE categoriadocente SET nombre = ? WHERE id = ?", categoriaDocente.getNombre(), categoriaDocente.getId());
    }

    @Override
    public void eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT * from categoriadocente WHERE categoriadocente.id = ?", new CategoriaDocenteMapper(), id);
    }

    @Override
    public List getAll() {
        return this.jdbcTemplate.query("SELECT * from categoriadocente ORDER BY categoriadocente.nombre", new CategoriaDocenteMapper());
    }

    /**
     * @return the jdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    private static final class CategoriaDocenteMapper implements RowMapper<CategoriaDocente> {

        @Override
        public CategoriaDocente mapRow(ResultSet rs, int rowNum) throws SQLException {
            CategoriaDocente categoriaDocente = new CategoriaDocente();
            categoriaDocente.setNombre(rs.getString("nombre"));            
            categoriaDocente.setId(rs.getLong("id"));
            return categoriaDocente;
        }
    }
}
