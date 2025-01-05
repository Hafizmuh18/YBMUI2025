package formakara.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBuyerDTO {
    private String nama;
    private String asalSekolah;
    private String noHp;
    private String email;
}
