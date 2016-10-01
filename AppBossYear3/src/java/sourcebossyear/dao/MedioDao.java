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
import sourcebossyear.modelo.Medio;

/**
 *
 * @author Leydis & Eduardo
 */
@Repository
public class MedioDao implements DaoGenerico{
    
    @Resource
    private JdbcTemplate jdbcTemplate;

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

    @Override
    public void salvar(Object object) {
         Medio medio = (Medio) object;
        this.getJdbcTemplate().update("insert into medio(nombre) values(?)", medio.getNombre());
    }

    @Override
    public void actulizar(Object object) {
        Medio medio = (Medio) object;
        this.jdbcTemplate.update("UPDATE medio SET nombre = ? WHERE id = ?", medio.getNombre(), medio.getId());
    }

    @Override
    public void eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Long id) {
       return this.jdbcTemplate.queryForObject("SELECT * from medio WHERE medio.id = ?", new MedioMapper(), id);
    }

    @Override
    public List getAll() {
        return this.jdbcTemplate.query("SELECT * from medio ORDER BY medio.nombre", new MedioMapper());
    }
    
    
    private static final class MedioMapper implements RowMapper<Medio> {

        @Override
        public Medio mapRow(ResultSet rs, int rowNum) throws SQLException {
            Medio medio = new Medio();
            medio.setNombre(rs.getString("nombre"));            
            medio.setId(rs.getLong("id"));
            return medio;
        }
    }
    
}
