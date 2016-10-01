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
import sourcebossyear.modelo.TipoActividad;

/**
 *
 * @author Leydis & Eduardo
 */
@Repository
public class TipoActividadDao implements DaoGenerico{

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
        TipoActividad tipoActividad = (TipoActividad) object;
        this.getJdbcTemplate().update("insert into tipoactividad(nombre) values(?)", tipoActividad.getNombre());
    }

    @Override
    public void actulizar(Object object) {
        TipoActividad tipoActividad = (TipoActividad) object;
        this.jdbcTemplate.update("UPDATE tipoactividad SET nombre = ? WHERE id = ?", tipoActividad.getNombre(), tipoActividad.getId());
    }

    @Override
    public void eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT * from tipoactividad WHERE tipoactividad.id = ?", new TipoActividadMapper(), id);
    }

    @Override
    public List getAll() {
         return this.jdbcTemplate.query("SELECT * from tipoactividad ORDER BY tipoactividad.nombre", new TipoActividadMapper());
    }
    
    private static final class TipoActividadMapper implements RowMapper<TipoActividad> {

        @Override
        public TipoActividad mapRow(ResultSet rs, int rowNum) throws SQLException {
            TipoActividad tipoActividad = new TipoActividad();
            tipoActividad.setNombre(rs.getString("nombre"));            
            tipoActividad.setId(rs.getLong("id"));
            return tipoActividad;
        }
    }
    
}
