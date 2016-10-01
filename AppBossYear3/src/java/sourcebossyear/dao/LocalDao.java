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
import sourcebossyear.modelo.Local;

/**
 *
 * @author Leydis & Eduardo
 */
@Repository
public class LocalDao implements DaoGenerico {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void salvar(Object object) {
        Local local = (Local) object;
        this.getJdbcTemplate().update("insert into local(nombre) values(?)", local.getNombre());
    }

    @Override
    public void actulizar(Object object) {
        Local local = (Local) object;
        this.jdbcTemplate.update("UPDATE local SET nombre = ? WHERE id = ?", local.getNombre(), local.getId());
    }

    @Override
    public void eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT * from local WHERE local.id = ?", new LocalMapper(), id);
    }

    @Override
    public List getAll() {
        return this.jdbcTemplate.query("SELECT * from local ORDER BY local.nombre", new LocalMapper());
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
    
    private static final class LocalMapper implements RowMapper<Local> {

        @Override
        public Local mapRow(ResultSet rs, int rowNum) throws SQLException {
            Local local = new Local();
            local.setNombre(rs.getString("nombre"));            
            local.setId(rs.getLong("id"));
            return local;
        }
    }
}
