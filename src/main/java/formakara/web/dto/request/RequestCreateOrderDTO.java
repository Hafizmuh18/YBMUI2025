package formakara.web.dto.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateOrderDTO {
    private String jenisOrder;
    private boolean offlineOrder;
    private String nominal;
    private String email1;
    private String email2;
    private String nama1;
    private String nama2;
    private String asalSekolah1;
    private String asalSekolah2;
    private String noHp1;
    private String noHp2;
    private MultipartFile bukti; 
}
