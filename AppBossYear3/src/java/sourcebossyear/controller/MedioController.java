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
import sourcebossyear.modelo.Local;
import sourcebossyear.modelo.Medio;
import sourcebossyear.servicio.MedioServicio;

/**
 *
 * @author Leydis & Eduardo
 */
@Controller
@RequestMapping("medio")
public class MedioController {
    
    @Resource
    private MedioServicio medioServicio;

    /**
     *
     * @param model
     * @param isDatosInsertados
     * @param isProblemaInsercion
     * @return
     */
    @RequestMapping(value = "/salvar", method = RequestMethod.GET)
    public String salvarAction(Model model, boolean isDatosInsertados, boolean isProblemaInsercion) {
        Medio medio = new Medio();

        model.addAttribute("medio", medio);
        model.addAttribute("isDatosInsertados", isDatosInsertados);
        model.addAttribute("isProblemaInsercion", isProblemaInsercion);
        return "nome/incluirMedio";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarAction(Model model, Medio medio) {
        try {
            this.medioServicio.salvar(medio);
        } catch (Exception e) {
            return this.salvarAction(model, false, true);
        }
        return this.salvarAction(model, true, false);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String listarAction(Model model) {

        List<Medio> medios = this.medioServicio.getAll();
        model.addAttribute("medios", medios);

        if (!model.containsAttribute("isDatosActualizados")) {
            model.addAttribute("isDatosActualizados", false);
        }

        return "nome/listarMedio";
    }
    
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarAction(Model model, Long id, boolean isProblemaActualizacion) {

        Medio medio = this.medioServicio.get(id);
        model.addAttribute("medio", medio);
        model.addAttribute("isProblemaActualizacion", isProblemaActualizacion);

        return "nome/editarMedio";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarAction(Model model, RedirectAttributes redirectAttributes, Medio medio) {

        try {
            this.medioServicio.actualizar(medio);
        } catch (Exception e) {
            return this.editarAction(model, medio.getId(), true);
        }       
        redirectAttributes.addFlashAttribute("isDatosActualizados", true);
        return "redirect:/medio";
    }
    
    /**
     * @return the medioServicio
     */
    public MedioServicio getMedioServicio() {
        return medioServicio;
    }

    /**
     * @param medioServicio the medioServicio to set
     */
    public void setMedioServicio(MedioServicio medioServicio) {
        this.medioServicio = medioServicio;
    }
    
    
}
