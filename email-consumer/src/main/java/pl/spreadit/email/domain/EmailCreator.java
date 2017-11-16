package pl.spreadit.email.domain;

import pl.spreadit.email.dto.CreateEmailDTO;
import pl.spreadit.email.dto.EmailDTO;

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
