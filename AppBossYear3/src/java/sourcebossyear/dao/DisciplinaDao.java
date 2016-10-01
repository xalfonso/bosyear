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
import sourcebossyear.modelo.Disciplina;

/**
 *
 * @author Leydis & Eduardo
 */
@Repository
public class DisciplinaDao implements DaoGenerico {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void salvar(Object object) {
        Disciplina disciplina = (Disciplina) object;
        this.getJdbcTemplate().update("insert into disciplina(nombre) values(?)", disciplina.getNombre());
    }

    @Override
    public void actulizar(Object object) {
        Disciplina disciplina = (Disciplina) object;
        this.jdbcTemplate.update("UPDATE disciplina SET nombre = ? WHERE id = ?", disciplina.getNombre(), disciplina.getId());
    }

    @Override
    public void eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT * from disciplina WHERE disciplina.id = ?", new DisciplinaMapper(), id);
    }

    @Override
    public List getAll() {
        return this.jdbcTemplate.query("SELECT * from disciplina ORDER BY disciplina.nombre", new DisciplinaMapper());
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

    private static final class DisciplinaMapper implements RowMapper<Disciplina> {

        @Override
        public Disciplina mapRow(ResultSet rs, int rowNum) throws SQLException {
            Disciplina disciplina = new Disciplina();
            disciplina.setNombre(rs.getString("nombre"));            
            disciplina.setId(rs.getLong("id"));
            return disciplina;
        }
    }
}
