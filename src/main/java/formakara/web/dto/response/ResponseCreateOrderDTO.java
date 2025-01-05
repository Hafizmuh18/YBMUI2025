package formakara.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCreateOrderDTO {
    private String jenis;
    private String email1;
    private String email2;
    private String noHp1;
    private String noHp2;
    private String username1;
    private String username2;
    private String password1;
    private String password2;
}
