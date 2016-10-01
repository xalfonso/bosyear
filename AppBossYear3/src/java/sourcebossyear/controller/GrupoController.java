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
import sourcebossyear.servicio.GrupoServicio;

/**
 *
 * @author Leydis & Eduardo
 */
@Controller
@RequestMapping("grupo")
public class GrupoController {

    protected final Log logger = LogFactory.getLog(getClass());

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
        Grupo grupo = new Grupo();

        model.addAttribute("grupo", grupo);
        model.addAttribute("isDatosInsertados", isDatosInsertados);
        model.addAttribute("isProblemaInsercion", isProblemaInsercion);
        return "estudiante/incluirGrupo";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarAction(Model model, Grupo grupo) {
        try {
            this.grupoServicio.salvar(grupo);
        } catch (Exception e) {
            return this.salvarAction(model, false, true);
        }
        return this.salvarAction(model, true, false);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listarAction(Model model) {

        List<Grupo> grupos = this.grupoServicio.getAll();
        model.addAttribute("grupos", grupos);

        if (!model.containsAttribute("isDatosActualizados")) {
            model.addAttribute("isDatosActualizados", false);
        }

        return "estudiante/listarGrupo";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarAction(Model model, Long id, boolean isProblemaActualizacion) {

        Grupo grupo = this.grupoServicio.get(id);
        model.addAttribute("grupo", grupo);
        model.addAttribute("isProblemaActualizacion", isProblemaActualizacion);

        return "estudiante/editarGrupo";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarAction(Model model, RedirectAttributes redirectAttributes, Grupo grupo) {

        try {
            this.grupoServicio.actualizar(grupo);
        } catch (Exception e) {
            return this.editarAction(model, grupo.getId(), true);
        }

        /**
         * Aqui agrego un atributo flash. Este atributo va ha estar disponible
         * solo hasta la proxima peticion Aqregandolo a RedirectAttributes
         * tambien se agrega a Model y estara disponible -en este caso- en el
         * metodo listarAction
         */
        redirectAttributes.addFlashAttribute("isDatosActualizados", true);
        return "redirect:/grupo";
    }

    /* @RequestMapping(value = "/editar", method = RequestMethod.POST)
     public String editarAction(Model model, Grupo grupo, Long id){
        
        
        
     return this.editarAction(model, id);
     }*/
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
