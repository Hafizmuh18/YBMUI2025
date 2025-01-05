package formakara.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formakara.web.dto.request.RequestLoginDTO;
import formakara.web.repository.BuyerDb;
import formakara.web.repository.TiketSeminarDb;
import formakara.web.repository.TiketToDb;

@Service
public class LoginService {
    @Autowired
    BuyerDb buyerDb;

    @Autowired
    TiketSeminarDb tiketSeminarDb;

    @Autowired
    TiketToDb tiketToDb;

    public void processLogin(RequestLoginDTO loginDTO){
        
    }
}
