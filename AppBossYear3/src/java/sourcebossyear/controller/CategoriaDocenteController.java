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
import sourcebossyear.modelo.CategoriaDocente;
import sourcebossyear.servicio.CategoriaDocenteServicio;

/**
 *
 * @author Leydis & Eduardo
 */
@Controller
@RequestMapping("categoriad")
public class CategoriaDocenteController {
    
    @Resource
    private CategoriaDocenteServicio categoriaDocenteServicio;

    /**
     *
     * @param model
     * @param isDatosInsertados
     * @param isProblemaInsercion
     * @return
     */
    @RequestMapping(value = "/salvar", method = RequestMethod.GET)
    public String salvarAction(Model model, boolean isDatosInsertados, boolean isProblemaInsercion) {
        CategoriaDocente categoriaDocente = new CategoriaDocente();

        model.addAttribute("categoriad", categoriaDocente);
        model.addAttribute("isDatosInsertados", isDatosInsertados);
        model.addAttribute("isProblemaInsercion", isProblemaInsercion);
        return "nome/incluirCategoriaDocente";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarAction(Model model, CategoriaDocente categoriaDocente) {
        try {
            this.categoriaDocenteServicio.salvar(categoriaDocente);
        } catch (Exception e) {
            return this.salvarAction(model, false, true);
        }
        return this.salvarAction(model, true, false);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String listarAction(Model model) {

        List<CategoriaDocente> categorias = this.categoriaDocenteServicio.getAll();
        model.addAttribute("categorias", categorias);

        if (!model.containsAttribute("isDatosActualizados")) {
            model.addAttribute("isDatosActualizados", false);
        }

        return "nome/listarCategoriaDocente";
    }
    
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarAction(Model model, Long id, boolean isProblemaActualizacion) {

        CategoriaDocente categoriaDocente = this.categoriaDocenteServicio.get(id);
        model.addAttribute("categoria", categoriaDocente);
        model.addAttribute("isProblemaActualizacion", isProblemaActualizacion);

        return "nome/editarCategoriaDocente";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarAction(Model model, RedirectAttributes redirectAttributes, CategoriaDocente categoriaDocente) {

        try {
            this.categoriaDocenteServicio.actualizar(categoriaDocente);
        } catch (Exception e) {
            return this.editarAction(model, categoriaDocente.getId(), true);
        }       
        redirectAttributes.addFlashAttribute("isDatosActualizados", true);
        return "redirect:/categoriad";
    }
    
    /**
     * @return the categoriaDocenteServicio
     */
    public CategoriaDocenteServicio getCategoriaDocenteServicio() {
        return categoriaDocenteServicio;
    }

    /**
     * @param categoriaDocenteServicio the categoriaDocenteServicio to set
     */
    public void setCategoriaDocenteServicio(CategoriaDocenteServicio categoriaDocenteServicio) {
        this.categoriaDocenteServicio = categoriaDocenteServicio;
    }
}
