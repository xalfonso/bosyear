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
import sourcebossyear.modelo.SemanaP1;

/**
 *
 * @author Leydis & Eduardo
 */
@Repository
public class SemanaP1Dao implements DaoGenerico{
    
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
        SemanaP1 semanaP1 = (SemanaP1) object;
        this.getJdbcTemplate().update("insert into semanap1(nombre) values(?)", semanaP1.getNombre());
    }

    @Override
    public void actulizar(Object object) {
        SemanaP1 semanaP1 = (SemanaP1) object;
        this.jdbcTemplate.update("UPDATE semanap1 SET nombre = ? WHERE id = ?", semanaP1.getNombre(), semanaP1.getId());
    }

    @Override
    public void eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT * from semanap1 WHERE semanap1.id = ?", new SemanaP1Mapper(), id);
    }

    @Override
    public List getAll() {
        return this.jdbcTemplate.query("SELECT * from semanap1 ORDER BY semanap1.nombre", new SemanaP1Mapper());
    }
    
    
    private static final class SemanaP1Mapper implements RowMapper<SemanaP1> {

        @Override
        public SemanaP1 mapRow(ResultSet rs, int rowNum) throws SQLException {
            SemanaP1 semanaP1 = new SemanaP1();
            semanaP1.setNombre(rs.getString("nombre"));            
            semanaP1.setId(rs.getLong("id"));
            return semanaP1;
        }
    }
}
