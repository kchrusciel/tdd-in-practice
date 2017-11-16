package pl.spreadit.email.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by CodeCouple.pl
 */
@Configuration
class EmailConfiguration {

    @Bean
    EmailFacade emailFacade(EmailRepository emailRepository){
        EmailCreator creator = new EmailCreator();
        return new EmailFacade(emailRepository, creator);
    }

    EmailFacade emailFacade(){
        InMemoryRepository repository = new InMemoryRepository();
        return emailFacade(repository);
    }

}
