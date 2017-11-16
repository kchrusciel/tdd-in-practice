package pl.spreadit.email.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class CreateEmailDTO {

    private String title;
    private String content;

}
