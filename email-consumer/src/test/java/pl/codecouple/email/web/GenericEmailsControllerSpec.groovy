package pl.codecouple.email.web

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import pl.codecouple.email.domain.EmailFacade
import pl.codecouple.email.dto.EmailDTO
import spock.lang.Specification

import static org.mockito.Mockito.when

/**
 * Created by CodeCouple.pl
 */
@WebMvcTest(GenericEmailsController)
class GenericEmailsControllerSpec extends Specification {

    @Autowired
    WebDriver webDriver

    @MockBean
    EmailFacade emailFacade

    def "Should show list of emails from DB on '/generic-emails'"() {
        given:
            def emailToReturn = EmailDTO.builder().title("title").content("content").id(1).build()
            def emails = Collections.singletonList(emailToReturn)
            when(emailFacade.findAll()).thenReturn(emails)
            webDriver.get("/generic-emails")
        when:
            def result = webDriver.findElement(By.id("1"))
        then:
            result.findElement(By.tagName("h3")).getText() == emailToReturn.getTitle()
            result.findElement(By.tagName("p")).getText() == emailToReturn.getContent()
    }

}