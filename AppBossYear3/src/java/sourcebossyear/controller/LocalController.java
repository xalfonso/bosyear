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
import sourcebossyear.servicio.LocalServicio;

/**
 *
 * @author Leydis & Eduardo
 */
@Controller
@RequestMapping("local")
public class LocalController {
    
    @Resource
    private LocalServicio localServicio;
    
    /**
     *
     * @param model
     * @param isDatosInsertados
     * @param isProblemaInsercion
     * @return
     */
    @RequestMapping(value = "/salvar", method = RequestMethod.GET)
    public String salvarAction(Model model, boolean isDatosInsertados, boolean isProblemaInsercion) {
        Local local = new Local();

        model.addAttribute("local", local);
        model.addAttribute("isDatosInsertados", isDatosInsertados);
        model.addAttribute("isProblemaInsercion", isProblemaInsercion);
        return "nome/incluirLocal";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarAction(Model model, Local local) {
        try {
            this.localServicio.salvar(local);
        } catch (Exception e) {
            return this.salvarAction(model, false, true);
        }
        return this.salvarAction(model, true, false);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String listarAction(Model model) {

        List<Local> locals = this.localServicio.getAll();
        model.addAttribute("locales", locals);

        if (!model.containsAttribute("isDatosActualizados")) {
            model.addAttribute("isDatosActualizados", false);
        }

        return "nome/listarLocal";
    }
    
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarAction(Model model, Long id, boolean isProblemaActualizacion) {

        Local local = this.localServicio.get(id);
        model.addAttribute("local", local);
        model.addAttribute("isProblemaActualizacion", isProblemaActualizacion);

        return "nome/editarLocal";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarAction(Model model, RedirectAttributes redirectAttributes, Local local) {

        try {
            this.localServicio.actualizar(local);
        } catch (Exception e) {
            return this.editarAction(model, local.getId(), true);
        }       
        redirectAttributes.addFlashAttribute("isDatosActualizados", true);
        return "redirect:/local";
    }
    
    
    /**
     * @return the localServicio
     */
    public LocalServicio getLocalServicio() {
        return localServicio;
    }

    /**
     * @param localServicio the localServicio to set
     */
    public void setLocalServicio(LocalServicio localServicio) {
        this.localServicio = localServicio;
    }
    
    
    
}
