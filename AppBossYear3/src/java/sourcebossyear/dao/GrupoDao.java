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
import sourcebossyear.modelo.Grupo;

/**
 *
 * @author Leydis & Eduardo
 */
@Repository
public class GrupoDao implements DaoGenerico {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void salvar(Object object) {
        Grupo grupo = (Grupo) object;
        this.jdbcTemplate.update("insert into grupo(nombre,year) values(?,?)", grupo.getNombre(), grupo.getYear());
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

    @Override
    public void actulizar(Object object) {
        Grupo grupo = (Grupo) object;
        this.jdbcTemplate.update("UPDATE grupo SET nombre = ?, year = ? WHERE id = ?", grupo.getNombre(), grupo.getYear(), grupo.getId());
    }

    @Override
    public void eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT * from grupo WHERE grupo.id = ?", new GrupoMapper(), id);
    }

    @Override
    public List<Grupo> getAll() {
        return this.jdbcTemplate.query("SELECT * from grupo ORDER BY grupo.nombre", new GrupoMapper());
    }

    /**
     * Se utiliza para mapear grupo con el resultado de las consultas
     */
    private static final class GrupoMapper implements RowMapper<Grupo> {

        public Grupo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Grupo grupo = new Grupo();
            grupo.setNombre(rs.getString("nombre"));
            grupo.setYear(rs.getInt("year"));
            grupo.setId(rs.getLong("id"));
            return grupo;
        }
    }

}
