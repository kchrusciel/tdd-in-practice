package pl.codecouple.email.api

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import pl.codecouple.email.domain.EmailFacade
import pl.codecouple.email.dto.CreateEmailDTO
import pl.codecouple.email.dto.EmailDTO
import spock.lang.Specification

import static org.mockito.Mockito.when
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
/**
 * Created by CodeCouple.pl
 */
@WebMvcTest(GenericEmailsAPIController)
class GenericEmailsAPIControllerSpec extends Specification {

    @Autowired
    MockMvc mvc

    @MockBean
    EmailFacade emailFacade

    private final ObjectMapper objectMapper = new ObjectMapper()

    def "Should add email to DB"() {
        given: "Email to add"
            def emailToAdd = CreateEmailDTO.builder()
                    .title("title")
                    .content("content")
                    .build()
            def emailFromDB = EmailDTO.builder()
                    .title("title")
                    .content("content")
                    .id(1)
                    .build()
            when(emailFacade.save(emailToAdd)).thenReturn(emailFromDB)
        when:
            def result = mvc.perform(post("/api/generic-emails")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(objectMapper.writeValueAsString(emailToAdd)))

        then:
            result.andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(emailFromDB)))

    }

}