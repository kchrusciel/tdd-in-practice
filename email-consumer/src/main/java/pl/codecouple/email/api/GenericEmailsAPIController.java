package pl.codecouple.email.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.codecouple.email.domain.EmailFacade;
import pl.codecouple.email.dto.CreateEmailDTO;
import pl.codecouple.email.dto.EmailDTO;

import java.util.List;


@RestController
@RequestMapping("/api/generic-emails")
class GenericEmailsAPIController {

    private final EmailFacade emailFacade;

    GenericEmailsAPIController(EmailFacade emailFacade) {
        this.emailFacade = emailFacade;
    }

    @GetMapping
    List<EmailDTO> getAllEmails() {
        return emailFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EmailDTO addEmail(@RequestBody CreateEmailDTO createEmailDTO) {
        return emailFacade.save(createEmailDTO);
    }
}
