/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sourcebossyear.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Leydis & Eduardo
 */
@Controller
public class indexController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    
    @RequestMapping("/home")
    public ModelAndView inicio() {

        String valor = "Leydis Esther Garzon";
        logger.info("Leydis");
        return new ModelAndView("home", "variable", valor);
    }
}
