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
import sourcebossyear.modelo.SemanaP1;
import sourcebossyear.servicio.SemanaP1Servicio;

/**
 *
 * @author Leydis & Eduardo
 */
@Controller
@RequestMapping("semanap1")
public class SemanaP1Controller {
    
    @Resource
    private SemanaP1Servicio semanaP1Servicio;

    /**
     *
     * @param model
     * @param isDatosInsertados
     * @param isProblemaInsercion
     * @return
     */
    @RequestMapping(value = "/salvar", method = RequestMethod.GET)
    public String salvarAction(Model model, boolean isDatosInsertados, boolean isProblemaInsercion) {
        SemanaP1 semanaP1 = new SemanaP1();

        model.addAttribute("semanap1", semanaP1);
        model.addAttribute("isDatosInsertados", isDatosInsertados);
        model.addAttribute("isProblemaInsercion", isProblemaInsercion);
        return "nome/incluirSemanaP1";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarAction(Model model, SemanaP1 semanaP1) {
        try {
            this.semanaP1Servicio.salvar(semanaP1);
        } catch (Exception e) {
            return this.salvarAction(model, false, true);
        }
        return this.salvarAction(model, true, false);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String listarAction(Model model) {

        List<SemanaP1> semanaP1s = this.semanaP1Servicio.getAll();
        model.addAttribute("semanasp1", semanaP1s);

        if (!model.containsAttribute("isDatosActualizados")) {
            model.addAttribute("isDatosActualizados", false);
        }

        return "nome/listarSemanaP1";
    }
    
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarAction(Model model, Long id, boolean isProblemaActualizacion) {

        SemanaP1 semanaP1 = this.semanaP1Servicio.get(id);
        model.addAttribute("semanap1", semanaP1);
        model.addAttribute("isProblemaActualizacion", isProblemaActualizacion);

        return "nome/editarSemanaP1";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarAction(Model model, RedirectAttributes redirectAttributes, SemanaP1 semanaP1) {

        try {
            this.semanaP1Servicio.actualizar(semanaP1);
        } catch (Exception e) {
            return this.editarAction(model, semanaP1.getId(), true);
        }       
        redirectAttributes.addFlashAttribute("isDatosActualizados", true);
        return "redirect:/semanap1";
    }
    
    /**
     * @return the semanaP1Servicio
     */
    public SemanaP1Servicio getSemanaP1Servicio() {
        return semanaP1Servicio;
    }

    /**
     * @param semanaP1Servicio the semanaP1Servicio to set
     */
    public void setSemanaP1Servicio(SemanaP1Servicio semanaP1Servicio) {
        this.semanaP1Servicio = semanaP1Servicio;
    }
}
