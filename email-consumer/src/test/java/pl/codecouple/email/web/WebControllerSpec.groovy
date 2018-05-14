package pl.codecouple.email.web

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import spock.lang.Specification
/**
 * Created by CodeCouple.pl
 */
@WebMvcTest(WebController)
class WebControllerSpec extends Specification {

    //Piramida
    //End-To-End
    //Integracyjne
    //Jednostkowe

    //Selenium
    //HTMLUnit

    @Autowired
    WebDriver webDriver

    //aaa_aaa_aaa
    //shouldReturn

    //BDD
    //GivenWhenThen

    def "Should show page with h3 header 'Emails:' on '/'" () {
        given:
            webDriver.get("/")
        when:
            def result = webDriver.findElement(By.tagName("h3"))
        then:
            result.getText() == "Emails:"
    }

}