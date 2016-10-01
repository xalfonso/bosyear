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
import sourcebossyear.modelo.Estudiante;
import sourcebossyear.modelo.Grupo;

/**
 *
 * @author Leydis & Eduardo
 */
@Repository
public class EstudianteDao implements DaoGenerico {

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
        Estudiante estudiante = (Estudiante) object;
        this.jdbcTemplate.update("insert into estudiante(primernombre,segundonombre,primerapellido,segundoapellido,grupo) values(?,?,?,?,?)", estudiante.getPrimerNombre(), estudiante.getSegundoNombre(), estudiante.getPrimerApellido(), estudiante.getSegundoApellido(), estudiante.getGrupo().getId());
    }

    @Override
    public void actulizar(Object object) {
       Estudiante estudiante = (Estudiante) object;
        this.jdbcTemplate.update("UPDATE estudiante SET primernombre = ?, segundonombre = ?, primerapellido = ?, segundoapellido = ?, grupo = ? WHERE id = ?", estudiante.getPrimerNombre(), estudiante.getSegundoNombre(), estudiante.getPrimerApellido(), estudiante.getSegundoApellido(), estudiante.getGrupo().getId(), estudiante.getId());
    }

    @Override
    public void eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Object get(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT estudiante.id, estudiante.primernombre, estudiante.segundonombre, estudiante.primerapellido, estudiante.segundoapellido, estudiante.grupo, grupo.nombre, grupo.year  FROM estudiante INNER JOIN grupo ON estudiante.grupo = grupo.id WHERE estudiante.id = ?", new EstudianteMapper(), id);
    }

    @Override
    public List getAll() {
        return this.jdbcTemplate.query("SELECT estudiante.id, estudiante.primernombre, estudiante.segundonombre, estudiante.primerapellido, estudiante.segundoapellido, estudiante.grupo, grupo.nombre, grupo.year  FROM estudiante INNER JOIN grupo ON estudiante.grupo = grupo.id ORDER BY grupo.nombre", new EstudianteMapper());
    }

    /**
     * Se utiliza para mapear grupo con el resultado de las consultas
     */
    private static final class EstudianteMapper implements RowMapper<Estudiante> {

        @Override
        public Estudiante mapRow(ResultSet rs, int rowNum) throws SQLException {
            Estudiante estudiante = new Estudiante();
            estudiante.setId(rs.getLong("id"));
            estudiante.setPrimerNombre(rs.getString("primernombre"));
            estudiante.setSegundoNombre(rs.getString("segundonombre"));
            estudiante.setPrimerApellido(rs.getString("primerapellido"));
            estudiante.setSegundoApellido(rs.getString("segundoapellido"));
            Grupo grupo = new Grupo();
            grupo.setId(rs.getLong("grupo"));
            grupo.setNombre(rs.getString("nombre"));
            grupo.setYear(rs.getInt("year"));
            estudiante.setGrupo(grupo);
            return estudiante;
        }
    }
}
