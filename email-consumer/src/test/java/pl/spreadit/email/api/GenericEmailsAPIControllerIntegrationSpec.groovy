package pl.spreadit.email.api

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.*
import org.springframework.web.client.RestTemplate
import pl.spreadit.email.dto.CreateEmailDTO
import pl.spreadit.email.dto.EmailDTO
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class GenericEmailsAPIControllerIntegrationSpec extends Specification {

    def "Should add email to DB"() {
        given:
            def restTemplate = new RestTemplate()
            def emailToAdd = CreateEmailDTO.builder()
                    .title("title")
                    .content("content")
                    .build()
            def headers = new HttpHeaders()
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
            def request = new HttpEntity<CreateEmailDTO>(emailToAdd, headers)
        when:
            def result = restTemplate.postForEntity(
                    "http://localhost:8080/api/generic-emails",
                    request,
                    EmailDTO.class)

        then:
            result.statusCode == HttpStatus.CREATED
            result.getBody().getId() == 1
    }

    def "Should return emails from DB"() {
        given:
            def restTemplate = new RestTemplate()
            def emailToAdd = CreateEmailDTO.builder()
                    .title("title")
                    .content("content")
                    .build()
            def headers = new HttpHeaders()
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
            def request = new HttpEntity<CreateEmailDTO>(emailToAdd, headers)
            restTemplate.postForEntity(
                    "http://localhost:8080/api/generic-emails",
                    request,
                    EmailDTO.class)
        when:
            def result = restTemplate.exchange(
                    "http://localhost:8080/api/generic-emails/",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<EmailDTO>>() {})
        then:
            result.getStatusCode() == HttpStatus.OK
            result.getBody().get(0).getTitle() == "title"
    }

}