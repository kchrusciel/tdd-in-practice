package pl.codecouple.email.domain

import pl.codecouple.email.dto.CreateEmailDTO
import spock.lang.Specification
/**
 * Created by CodeCouple.pl
 */
class EmailFacadeSpec extends Specification {

    def emailRepository = new InMemoryRepository()
    def emailFacade = new EmailConfiguration().emailFacade(emailRepository)

    def "Should return emails from DB" () {
        given:
            def emailToAdd = CreateEmailDTO.builder()
                    .content("content")
                    .title("title")
                    .build()
            emailFacade.save(emailToAdd)
        when:
            def result = emailFacade.findAll()
        then:
            result.size() == 1
            result.get(0).getId() == 1
    }

    def "Should add new email to DB" () {
        given:
            def emailToAdd = CreateEmailDTO.builder()
                    .content("content")
                    .title("title")
                    .build()
        when:
            def result = emailFacade.save(emailToAdd)
        then:
            result.getId() == 1
    }

}
