/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sourcebossyear.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sourcebossyear.modelo.Disciplina;
import sourcebossyear.servicio.DisciplinaServicio;

/**
 *
 * @author Leydis & Eduardo
 */
@Controller
@RequestMapping("disciplina")
public class DisciplinaController {
    
    @Resource
    private DisciplinaServicio disciplinaServicio;
    
    /**
     *
     * @param model
     * @param isDatosInsertados
     * @param isProblemaInsercion
     * @return
     */
    @RequestMapping(value = "/salvar", method = RequestMethod.GET)
    public String salvarAction(Model model, boolean isDatosInsertados, boolean isProblemaInsercion) {
        Disciplina disciplina = new Disciplina();

        model.addAttribute("disciplina", disciplina);
        model.addAttribute("isDatosInsertados", isDatosInsertados);
        model.addAttribute("isProblemaInsercion", isProblemaInsercion);
        return "asignatura/incluirDisciplina";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarAction(Model model, Disciplina disciplina) {
        try {
            this.disciplinaServicio.salvar(disciplina);
        } catch (Exception e) {
            return this.salvarAction(model, false, true);
        }
        return this.salvarAction(model, true, false);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String listarAction(Model model) {

        List<Disciplina> disciplinas = this.disciplinaServicio.getAll();
        model.addAttribute("disciplinas", disciplinas);

        if (!model.containsAttribute("isDatosActualizados")) {
            model.addAttribute("isDatosActualizados", false);
        }

        return "asignatura/listarDisciplina";
    }
    
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarAction(Model model, Long id, boolean isProblemaActualizacion) {

        Disciplina disciplina = this.disciplinaServicio.get(id);
        model.addAttribute("disciplina", disciplina);
        model.addAttribute("isProblemaActualizacion", isProblemaActualizacion);

        return "asignatura/editarDisciplina";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarAction(Model model, RedirectAttributes redirectAttributes, Disciplina disciplina) {

        try {
            this.disciplinaServicio.actualizar(disciplina);
        } catch (Exception e) {
            return this.editarAction(model, disciplina.getId(), true);
        }       
        redirectAttributes.addFlashAttribute("isDatosActualizados", true);
        return "redirect:/disciplina";
    }
    
    
    /**
     * @return the disciplinaServicio
     */
    public DisciplinaServicio getDisciplinaServicio() {
        return disciplinaServicio;
    }

    /**
     * @param disciplinaServicio the disciplinaServicio to set
     */
    public void setDisciplinaServicio(DisciplinaServicio disciplinaServicio) {
        this.disciplinaServicio = disciplinaServicio;
    }
}
