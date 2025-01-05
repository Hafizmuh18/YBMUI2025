package formakara.web.service;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formakara.web.dto.response.ResponseTiketSeminar;
import formakara.web.dto.response.ResponseTiketTo;
import formakara.web.models.Buyer;
import formakara.web.models.TiketSeminar;
import formakara.web.models.TiketTo;
import formakara.web.repository.TiketSeminarDb;
import formakara.web.repository.TiketToDb;

@Service
public class TiketService {
    @Autowired
    TiketSeminarDb tiketSeminarDb;

    @Autowired
    TiketToDb tiketToDb;

    @Autowired
    BuyerService buyerService;

    public TiketTo createTiketTo(Buyer buyer){
        TiketTo tiket = new TiketTo();
        String firstName = buyer.getNama().split(" ")[0];
        int size = tiketToDb.findAll().size();

        tiket.setEmail(buyer.getEmail());
        tiket.setNoHp(buyer.getNoHp());

        Random random = new Random();
        String rng = String.format("%03d", random.nextInt(1000));

        tiket.setUsername("YBM2025-"+firstName+size);
        tiket.setPassword(firstName+rng);
        tiket.setStatus("Menunggu Konfirmasi Pembayaran Oleh Panitia");
        return tiketToDb.save(tiket);
    }

    public TiketSeminar createTiketSeminar(Buyer buyer){
        TiketSeminar tiket = new TiketSeminar();
        tiket.setHadir(0);
        tiket.setStatus("Menunggu Konfirmasi Pembayaran Oleh Panitia");
        return tiketSeminarDb.save(tiket);
    }

    public ArrayList<ResponseTiketTo> findAllTiketTo(){
        ArrayList<ResponseTiketTo> listTiket = new ArrayList<>();
        for(TiketTo tiket : tiketToDb.findAll()){
            listTiket.add(tiketToDTO(tiket));
        }
        return listTiket;
    }

    public TiketTo save(TiketTo tiket){
        return tiketToDb.save(tiket);
    }

    public TiketSeminar save(TiketSeminar tiket){
        return tiketSeminarDb.save(tiket);
    }

    public ArrayList<ResponseTiketSeminar> findAllTiketSeminar(){
        ArrayList<ResponseTiketSeminar> listTiket = new ArrayList<>();
        for(TiketSeminar tiket : tiketSeminarDb.findAll()){
            listTiket.add(tiketToDTO(tiket));
        }
        return listTiket;
    }

    public ResponseTiketTo tiketToDTO(TiketTo tiket){
        if(tiket == null){
            return null;
        }
        ResponseTiketTo dto = new ResponseTiketTo();
        dto.setId(tiket.getId());
        Buyer buyer = buyerService.findByTiketTo(tiket);
        dto.setNama(buyer.getNama());
        dto.setAsalSekolah(buyer.getAsalSekolah());
        dto.setEmail(buyer.getEmail());
        dto.setNoHp(buyer.getNoHp());
        dto.setPassword(tiket.getPassword());
        dto.setUsername(tiket.getUsername());
        dto.setStatus(tiket.getStatus());
        return dto;
    }

    public ResponseTiketSeminar tiketToDTO(TiketSeminar tiket){
        if(tiket == null){
            return null;
        }
        ResponseTiketSeminar dto = new ResponseTiketSeminar();
        Buyer buyer = buyerService.findByTiketSeminar(tiket);
        dto.setId(tiket.getId());
        dto.setNama(buyer.getNama());
        dto.setNoHp(buyer.getNoHp());
        dto.setEmail(buyer.getEmail());
        dto.setStatus(tiket.getStatus());
        dto.setAsalSekolah(buyer.getAsalSekolah());
        dto.setHadir(tiket.getHadir());
        return dto;
    }

    public ResponseTiketTo getTiketToByEmail(String email){
        for(TiketTo tiket : tiketToDb.findAll()){
            if(buyerService.findByTiketTo(tiket)!=null&&buyerService.findByTiketTo(tiket).getEmail().equals(email)){
                return tiketToDTO(tiket);
            }
        }
        return null;
    }

    public ResponseTiketSeminar getTiketSeminarByEmail(String email){
        for(TiketSeminar tiket : tiketSeminarDb.findAll()){
            if(buyerService.findByTiketSeminar(tiket)!=null&&buyerService.findByTiketSeminar(tiket).getEmail().equals(email)){
                return tiketToDTO(tiket);
            }
        }
        return null;
    }
}
