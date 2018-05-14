package pl.codecouple.email.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.codecouple.email.dto.EmailDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
class Email {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;

    EmailDTO dto() {
        return EmailDTO.builder()
                .id(id)
                .content(content)
                .title(title)
                .build();
    }

}
