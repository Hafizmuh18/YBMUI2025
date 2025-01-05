package formakara.web.dto.response;

import java.util.Base64;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOrderDTO {
    private int id;
    private String jenisOrder;
    private boolean offlineOrder;
    private String statusPembayaran;
    private String nominal;
    private ResponseBuyerDTO buyer1;
    private ResponseBuyerDTO buyer2;
    private byte[] bukti;
    private ResponseTiketSeminar tiketSeminar1;
    private ResponseTiketSeminar tiketSeminar2;
    private ResponseTiketTo tiketTo1;
    private ResponseTiketTo tiketTo2;

    public String getBuktiBase64() {
        if (bukti != null) {
            return Base64.getEncoder().encodeToString(bukti);
        }
        return null;
    }
}
