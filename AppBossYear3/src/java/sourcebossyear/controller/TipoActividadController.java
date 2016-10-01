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
import sourcebossyear.modelo.TipoActividad;
import sourcebossyear.servicio.TipoActividadServicio;

/**
 *
 * @author Leydis & Eduardo
 */
@Controller
@RequestMapping("tipoactividad")
public class TipoActividadController {

    @Resource
    private TipoActividadServicio tipoActividadServicio;

    /**
     *
     * @param model
     * @param isDatosInsertados
     * @param isProblemaInsercion
     * @return
     */
    @RequestMapping(value = "/salvar", method = RequestMethod.GET)
    public String salvarAction(Model model, boolean isDatosInsertados, boolean isProblemaInsercion) {
        TipoActividad tipoActividad = new TipoActividad();

        model.addAttribute("tipoactividad", tipoActividad);
        model.addAttribute("isDatosInsertados", isDatosInsertados);
        model.addAttribute("isProblemaInsercion", isProblemaInsercion);
        return "nome/incluirTipoActividad";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarAction(Model model, TipoActividad tipoActividad) {
        try {
            this.tipoActividadServicio.salvar(tipoActividad);
        } catch (Exception e) {
            return this.salvarAction(model, false, true);
        }
        return this.salvarAction(model, true, false);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listarAction(Model model) {

        List<TipoActividad> tipoActividads = this.tipoActividadServicio.getAll();
        model.addAttribute("tiposactividad", tipoActividads);

        if (!model.containsAttribute("isDatosActualizados")) {
            model.addAttribute("isDatosActualizados", false);
        }

        return "nome/listarTipoActividad";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarAction(Model model, Long id, boolean isProblemaActualizacion) {

        TipoActividad tipoActividad = this.tipoActividadServicio.get(id);
        model.addAttribute("tipoactividad", tipoActividad);
        model.addAttribute("isProblemaActualizacion", isProblemaActualizacion);

        return "nome/editarTipoActividad";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarAction(Model model, RedirectAttributes redirectAttributes, TipoActividad tipoActividad) {

        try {
            this.tipoActividadServicio.actualizar(tipoActividad);
        } catch (Exception e) {
            return this.editarAction(model, tipoActividad.getId(), true);
        }
        redirectAttributes.addFlashAttribute("isDatosActualizados", true);
        return "redirect:/tipoactividad";
    }

    /**
     * @return the tipoActividadServicio
     */
    public TipoActividadServicio getTipoActividadServicio() {
        return tipoActividadServicio;
    }

    /**
     * @param tipoActividadServicio the tipoActividadServicio to set
     */
    public void setTipoActividadServicio(TipoActividadServicio tipoActividadServicio) {
        this.tipoActividadServicio = tipoActividadServicio;
    }

}
