package pl.codecouple.email.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by CodeCouple.pl
 */
@Controller
@RequestMapping("/")
class WebController {

    @GetMapping
    String showIndexPage(){
        return "index";
    }

}
