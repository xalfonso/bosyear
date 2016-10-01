/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sourcebossyear.controller;

import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sourcebossyear.modelo.Grupo;
import sourcebossyear.modelo.Estudiante;
import sourcebossyear.servicio.EstudianteServicio;
import sourcebossyear.servicio.GrupoServicio;

/**
 *
 * @author Leydis & Eduardo
 */
@Controller
@RequestMapping("estudiante")
public class EstudianteController {

    protected final Log logger = LogFactory.getLog(getClass());
    @Resource
    private EstudianteServicio estudianteServicio;

    @Resource
    private GrupoServicio grupoServicio;

    /**
     *
     * @param model
     * @param isDatosInsertados
     * @param isProblemaInsercion
     * @return
     */
    @RequestMapping(value = "/salvar", method = RequestMethod.GET)
    public String salvarAction(Model model, boolean isDatosInsertados, boolean isProblemaInsercion) {
        Estudiante estudiante = new Estudiante();
        List<Grupo> grupos = this.grupoServicio.getAll();

        model.addAttribute("estudiante", estudiante);
        model.addAttribute("grupos", grupos);
        model.addAttribute("isDatosInsertados", isDatosInsertados);
        model.addAttribute("isProblemaInsercion", isProblemaInsercion);
        return "estudiante/incluirEstudiante";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarAction(Model model, Estudiante estudiante) {
        try {
            this.estudianteServicio.salvar(estudiante);
        } catch (Exception e) {
            return this.salvarAction(model, false, true);
        }
        return this.salvarAction(model, true, false);

    }

    @RequestMapping(method = RequestMethod.GET)
    public String listarAction(Model model) {

        List<Estudiante> estudiantes = this.estudianteServicio.getAll();
        model.addAttribute("estudiantes", estudiantes);

        if (!model.containsAttribute("isDatosActualizados")) {
            model.addAttribute("isDatosActualizados", false);
        }

        return "estudiante/listarEstudiante";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarAction(Model model, Long id, boolean isProblemaActualizacion) {

        Estudiante estudiante = this.estudianteServicio.get(id);
        List<Grupo> grupos = this.grupoServicio.getAll();
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("grupos", grupos);
        model.addAttribute("isProblemaActualizacion", isProblemaActualizacion);

        return "estudiante/editarEstudiante";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarAction(Model model, RedirectAttributes redirectAttributes, Estudiante estudiante) {

        try {
            this.estudianteServicio.actualizar(estudiante);
        } catch (Exception e) {
            return this.editarAction(model, estudiante.getId(), true);
        }
        redirectAttributes.addFlashAttribute("isDatosActualizados", true);
        return "redirect:/estudiante";
    }

    /*@RequestMapping("/listar/{grupo}")
     public ModelAndView listarEstudiantesAction(@PathVariable String grupo) {

     //String valor = "Esto es una prueba de mi primer controlador para el grupo " + grupo;
     String valor = "";
     Grupo grupo1 = new Grupo();
     grupo1.setNombre(grupo);
     grupo1.setYear(3);
     //this.grupoServicio.salvar(grupo1);
     logger.info("Se ha salvado");

     return new ModelAndView("home", "variable", valor);
     }*/

    /* @RequestMapping("/salvar/{grupo}")
     public String salvarEstudiante(Model model, @PathVariable String grupo) {

     model.addAttribute("variable", "este un metodo de forma diferente: " + grupo);
     return "home";
     }*/

    /*@RequestMapping(value = "/salvar", method = RequestMethod.GET)
     public String salvar(Model model) {

     return "estudiante/incluirEstudiante";
     }*/
    /*@RequestMapping
     public String initEstudiante(Model model) {

     model.addAttribute("variable", "Has accedido a la vista de estudiante por defecto: ");
     return "estudiante/incluirEstudiante";
     }*/
    /**
     * @return the estudianteServicio
     */
    public EstudianteServicio getEstudianteServicio() {
        return estudianteServicio;
    }

    /**
     * @param estudianteServicio the estudianteServicio to set
     */
    public void setEstudianteServicio(EstudianteServicio estudianteServicio) {
        this.estudianteServicio = estudianteServicio;
    }

    /**
     * @return the grupoServicio
     */
    public GrupoServicio getGrupoServicio() {
        return grupoServicio;
    }

    /**
     * @param grupoServicio the grupoServicio to set
     */
    public void setGrupoServicio(GrupoServicio grupoServicio) {
        this.grupoServicio = grupoServicio;
    }
}
