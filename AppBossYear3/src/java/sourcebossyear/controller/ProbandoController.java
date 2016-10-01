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
import sourcebossyear.modelo.Probando;
import sourcebossyear.servicio.GrupoServicio;

/**
 *
 * @author Leydis & Eduardo Alfonso
 */
@Controller
@RequestMapping("probando")
public class ProbandoController {
    protected final Log logger = LogFactory.getLog(getClass());
    
    //@Resource
    //private GrupoServicio grupoServicio;
    
    @RequestMapping(method = RequestMethod.GET)
    public String listarAction(Model model) {
    //List<Grupo> grupos = this.grupoServicio.getAll();
    Probando probando = new Probando();
    model.addAttribute("probando", probando);
    Probando proban2 = new Probando();
    model.addAttribute("proban2", proban2);
        return "probando/estudianteAsignatura";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String insertarAction(Probando probando, Probando proban2) {
        String[] arrestudiantes = probando.getEstudiantes();
        String[] arrasignaturas = proban2.getAsignaturas();
        for (String est : arrestudiantes) {
            logger.info("Estudiantes-> " + est);
        }
        for (String asg : arrasignaturas) {
            logger.info("Asignaturas-> " + asg);
        }
      
        return "probando/estudianteAsignatura";
    }
    
}
