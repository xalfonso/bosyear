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
import sourcebossyear.modelo.CategoriaCientifica;

/**
 *
 * @author Leydis & Eduardo
 */
@Repository
public class CategoriaCientificaDao implements DaoGenerico {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void salvar(Object object) {
        CategoriaCientifica categoriaCientifica = (CategoriaCientifica) object;
        this.getJdbcTemplate().update("insert into categoriacientifica(nombre) values(?)", categoriaCientifica.getNombre());
    }

    @Override
    public void actulizar(Object object) {
        CategoriaCientifica categoriaCientifica = (CategoriaCientifica) object;
        this.jdbcTemplate.update("UPDATE categoriacientifica SET nombre = ? WHERE id = ?", categoriaCientifica.getNombre(), categoriaCientifica.getId());
    }

    @Override
    public void eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT * from categoriacientifica WHERE categoriacientifica.id = ?", new CategoriaCientificaMapper(), id);
    }

    @Override
    public List getAll() {
        return this.jdbcTemplate.query("SELECT * from categoriacientifica ORDER BY categoriacientifica.nombre", new CategoriaCientificaMapper());
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

    private static final class CategoriaCientificaMapper implements RowMapper<CategoriaCientifica> {

        @Override
        public CategoriaCientifica mapRow(ResultSet rs, int rowNum) throws SQLException {
            CategoriaCientifica categoriaCientifica = new CategoriaCientifica();
            categoriaCientifica.setNombre(rs.getString("nombre"));            
            categoriaCientifica.setId(rs.getLong("id"));
            return categoriaCientifica;
        }
    }
}
