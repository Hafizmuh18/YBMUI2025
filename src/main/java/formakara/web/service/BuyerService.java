package formakara.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formakara.web.dto.response.ResponseBuyerDTO;
import formakara.web.models.Buyer;
import formakara.web.models.TiketSeminar;
import formakara.web.models.TiketTo;
import formakara.web.repository.BuyerDb;

@Service
public class BuyerService {
    @Autowired
    BuyerDb buyerDb;

    public Buyer findByNoHp(String noHp){
        for(Buyer buyer : buyerDb.findAll()){
            if(buyer.getNoHp().equals(noHp)){
                return buyer;
            }
        }
        return null;
    }

    public Buyer createBuyer(String nama, String email, String noHp, String asalSekolah){
        Buyer buyer = new Buyer();
        buyer.setEmail(email);
        buyer.setNama(nama);
        buyer.setNoHp(noHp);
        buyer.setAsalSekolah(asalSekolah);
        return buyerDb.save(buyer);
    }

    public Buyer save(Buyer buyer){
        return buyerDb.save(buyer);
    }

    public Buyer findById(int id){
        for(Buyer buyer : buyerDb.findAll()){
            if(buyer.getId() == id){
                return buyer;
            }
        }
        return null;
    }

    public Buyer findByTiketTo(TiketTo tiket){
        for(Buyer buyer : buyerDb.findAll()){
            if(buyer.getTiketTo() != null && buyer.getTiketTo().equals(tiket)){
                return buyer;
            }
        }
        return null;
    }

    public Buyer findByTiketSeminar(TiketSeminar tiket){
        for(Buyer buyer : buyerDb.findAll()){
            if(buyer.getTiketSeminar() != null && buyer.getTiketSeminar().equals(tiket)){
                return buyer;
            }
        }
        return null;
    }

    public ResponseBuyerDTO findBuyerByLogin(String emailHp){
        for(Buyer buyer : buyerDb.findAll()){
            if(buyer.getEmail().equals(emailHp)){
                return buyerToDTO(buyer);
            }
            if(buyer.getNoHp().equals(emailHp)){
                return buyerToDTO(buyer);
            }
        }
        return null;
    }

    public ResponseBuyerDTO buyerToDTO(Buyer buyer){
        if(buyer == null){
            return null;
        }
        ResponseBuyerDTO dto = new ResponseBuyerDTO();
        dto.setAsalSekolah(buyer.getAsalSekolah());
        dto.setEmail(buyer.getEmail());
        dto.setNama(buyer.getNama());
        dto.setNoHp(buyer.getNoHp());
        return dto;
    }
}
