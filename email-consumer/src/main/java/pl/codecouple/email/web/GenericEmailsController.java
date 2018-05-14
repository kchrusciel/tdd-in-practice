package pl.codecouple.email.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.codecouple.email.domain.EmailFacade;

@Controller
@RequestMapping("/generic-emails")
class GenericEmailsController {

    private final EmailFacade facade;

    public GenericEmailsController(EmailFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    ModelAndView showGenericEmails(ModelAndView modelAndView){
        modelAndView.setViewName("generic-emails");
        modelAndView.addObject("emails", facade.findAll());
        return modelAndView;
    }

}
