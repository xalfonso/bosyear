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
import sourcebossyear.modelo.CategoriaCientifica;
import sourcebossyear.servicio.CategoriaCientificaServicio;

/**
 *
 * @author Leydis & Eduardo
 */
@Controller
@RequestMapping("categoriac")
public class CategoriaCientificaController {
    
    @Resource
    private CategoriaCientificaServicio categoriaCientificaServicio;

    
    /**
     *
     * @param model
     * @param isDatosInsertados
     * @param isProblemaInsercion
     * @return
     */
    @RequestMapping(value = "/salvar", method = RequestMethod.GET)
    public String salvarAction(Model model, boolean isDatosInsertados, boolean isProblemaInsercion) {
        CategoriaCientifica categoriaCientifica = new CategoriaCientifica();

        model.addAttribute("categoriac", categoriaCientifica);
        model.addAttribute("isDatosInsertados", isDatosInsertados);
        model.addAttribute("isProblemaInsercion", isProblemaInsercion);
        return "nome/incluirCategoriaCientifica";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarAction(Model model, CategoriaCientifica categoriaCientifica) {
        try {
            this.categoriaCientificaServicio.salvar(categoriaCientifica);
        } catch (Exception e) {
            return this.salvarAction(model, false, true);
        }
        return this.salvarAction(model, true, false);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String listarAction(Model model) {

        List<CategoriaCientifica> categorias = this.categoriaCientificaServicio.getAll();
        model.addAttribute("categorias", categorias);

        if (!model.containsAttribute("isDatosActualizados")) {
            model.addAttribute("isDatosActualizados", false);
        }

        return "nome/listarCategoriaCientifica";
    }
    
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarAction(Model model, Long id, boolean isProblemaActualizacion) {

        CategoriaCientifica categoriaCientifica = this.categoriaCientificaServicio.get(id);
        model.addAttribute("categoria", categoriaCientifica);
        model.addAttribute("isProblemaActualizacion", isProblemaActualizacion);

        return "nome/editarCategoriaCientifica";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarAction(Model model, RedirectAttributes redirectAttributes, CategoriaCientifica categoriaCientifica) {

        try {
            this.categoriaCientificaServicio.actualizar(categoriaCientifica);
        } catch (Exception e) {
            return this.editarAction(model, categoriaCientifica.getId(), true);
        }       
        redirectAttributes.addFlashAttribute("isDatosActualizados", true);
        return "redirect:/categoriac";
    }
    
    /**
     * @return the categoriaCientificaServicio
     */
    public CategoriaCientificaServicio getCategoriaCientificaServicio() {
        return categoriaCientificaServicio;
    }

    /**
     * @param categoriaCientificaServicio the categoriaCientificaServicio to set
     */
    public void setCategoriaCientificaServicio(CategoriaCientificaServicio categoriaCientificaServicio) {
        this.categoriaCientificaServicio = categoriaCientificaServicio;
    }
}
