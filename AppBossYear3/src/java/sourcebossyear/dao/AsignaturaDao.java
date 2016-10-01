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
import sourcebossyear.modelo.Asignatura;
import sourcebossyear.modelo.Disciplina;
import sourcebossyear.servicio.DisciplinaServicio;
/**
 *
 * @author Leydis & Eduardo Alfonso
 */
@Repository
public class AsignaturaDao implements DaoGenerico {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private DisciplinaServicio disciplinaServicio;
    @Override
    public void salvar(Object object) {
        Asignatura asignatura = (Asignatura) object;
        this.getJdbcTemplate().update("insert into asignatura(nombre,year,disciplina) values(?,?,?)", asignatura.getNombre(), asignatura.getYear(), asignatura.getDisciplina());
    }

    @Override
    public void actulizar(Object object) {
        Asignatura asignatura = (Asignatura) object;
        this.jdbcTemplate.update("UPDATE asignatura SET nombre = ?, year = ?, disciplina = ? WHERE id = ?",asignatura.getNombre(), asignatura.getYear(), asignatura.getDisciplina(), asignatura.getId());
    }

    @Override
    public void eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT asignatura.*,disciplina.nombre asignomb from asignatura INNER JOIN disciplina on asignatura.disciplina=disciplina.id WHERE asignatura.id = ?", new AsignaturaMapper(), id);
    }

    @Override
    public List getAll() {
        return this.jdbcTemplate.query("SELECT asignatura.*,disciplina.nombre asignomb from asignatura INNER JOIN disciplina on asignatura.disciplina=disciplina.id ORDER BY asignatura.nombre", new AsignaturaMapper());
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

    private static final class AsignaturaMapper implements RowMapper<Asignatura> {

        @Override
        public Asignatura mapRow(ResultSet rs, int rowNum) throws SQLException {
            Asignatura asignatura = new Asignatura();
            Disciplina disciplina = new Disciplina();
            disciplina.setId(rs.getLong("disciplina"));
            disciplina.setNombre(rs.getString("asignomb"));
            asignatura.setNombre(rs.getString("nombre"));
            asignatura.setYear(rs.getInt("year"));
            asignatura.setDisciplina(disciplina);
            asignatura.setId(rs.getLong("id"));
            return asignatura;
        }
    }    
}
