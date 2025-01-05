package formakara.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTiketTo {
    private int id;
    private String nama;
    private String asalSekolah;
    private String noHp;
    private String email;
    private String status;
    private String username;
    private String password;
}
