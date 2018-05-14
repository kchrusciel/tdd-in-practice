package pl.codecouple.email.domain;

import pl.codecouple.email.dto.CreateEmailDTO;
import pl.codecouple.email.dto.EmailDTO;

class EmailCreator {

    Email from(CreateEmailDTO createEmailDTO){
        return Email.builder()
                .title(createEmailDTO.getTitle())
                .content(createEmailDTO.getContent())
                .build();
    }

    EmailDTO from(Email email){
        return EmailDTO.builder()
                .id(email.getId())
                .title(email.getTitle())
                .content(email.getContent())
                .build();
    }

}
