package pl.codecouple.email.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDTO {

    private long id;
    private String title;
    private String content;

}