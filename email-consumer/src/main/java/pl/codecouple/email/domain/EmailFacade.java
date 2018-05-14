package pl.codecouple.email.domain;

import pl.codecouple.email.dto.CreateEmailDTO;
import pl.codecouple.email.dto.EmailDTO;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by CodeCouple.pl
 */
public class EmailFacade {

    private final EmailRepository emailRepository;
    private final EmailCreator emailCreator;

    public EmailFacade(EmailRepository emailRepository, EmailCreator emailCreator) {
        this.emailRepository = emailRepository;
        this.emailCreator = emailCreator;
    }

    public List<EmailDTO> findAll(){
        return emailRepository.findAll().stream()
                .map(Email::dto)
                .collect(toList());
    }

    public EmailDTO save(CreateEmailDTO createEmailDTO){
        return emailRepository.save(emailCreator.from(createEmailDTO)).dto();
    }

}
