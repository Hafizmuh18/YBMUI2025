package formakara.web.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import formakara.web.dto.request.RequestCreateOrderDTO;
import formakara.web.dto.response.ResponseBuyerDTO;
import formakara.web.dto.response.ResponseCreateOrderDTO;
import formakara.web.dto.response.ResponseOrderDTO;
import formakara.web.dto.response.ResponseTiketSeminar;
import formakara.web.dto.response.ResponseTiketTo;
import formakara.web.models.Buyer;
import formakara.web.models.Order;
import formakara.web.models.TiketSeminar;
import formakara.web.models.TiketTo;
import formakara.web.repository.OrderDb;

@Service
public class OrderService {
    @Autowired
    OrderDb orderDb;

    @Autowired
    BuyerService buyerService;

    @Autowired
    TiketService tiketService;

    public ResponseCreateOrderDTO createOrder(RequestCreateOrderDTO requestDTO){
        try {
            System.out.println("\n\n\n");
            System.out.println(requestDTO.getAsalSekolah1());
            ResponseCreateOrderDTO responseDTO = new ResponseCreateOrderDTO();
            responseDTO.setJenis(requestDTO.getJenisOrder());
            Order order = new Order();

            order.setJenisOrder(requestDTO.getJenisOrder());
            order.setNominal(requestDTO.getNominal());
            order.setOfflineOrder(requestDTO.isOfflineOrder());
            order.setStatusPembayaran("Menunggu Konfirmasi Pembayaran dari Panitia");
            order.setBukti(requestDTO.getBukti().getBytes());

            if(requestDTO.getJenisOrder().contains("bundle")){
                System.out.println("masuk bundle");
                Buyer buyer1 = buyerService.findByNoHp(requestDTO.getNoHp1());
                if(buyer1 == null){
                    buyer1 = buyerService.createBuyer(requestDTO.getNama1(), requestDTO.getEmail1(), requestDTO.getNoHp1(), requestDTO.getAsalSekolah1());
                }

                Buyer buyer2 = buyerService.findByNoHp(requestDTO.getNoHp2());
                if(buyer2 == null){
                    buyer2 = buyerService.createBuyer(requestDTO.getNama2(), requestDTO.getEmail2(), requestDTO.getNoHp2(), requestDTO.getAsalSekolah2());
                }

                responseDTO.setEmail1(buyer1.getEmail());
                responseDTO.setNoHp1(buyer1.getNoHp());
                responseDTO.setEmail2(buyer2.getEmail());
                responseDTO.setNoHp2(buyer2.getNoHp());

                buyer1.setAsalSekolah(requestDTO.getAsalSekolah1());
                buyer2.setAsalSekolah(requestDTO.getAsalSekolah2());

                buyerService.save(buyer1);
                buyerService.save(buyer2);

                if(requestDTO.getJenisOrder().contains("to-seminar")){
                    System.out.println("masuk to-seminar");
                    TiketTo ticketTo1 = tiketService.createTiketTo(buyer1);
                    TiketTo ticketTo2 = tiketService.createTiketTo(buyer2);

                    TiketSeminar tiketSeminar1 = tiketService.createTiketSeminar(buyer1);
                    TiketSeminar tiketSeminar2 = tiketService.createTiketSeminar(buyer2);

                    buyer1.setTiketTo(ticketTo1);
                    buyer2.setTiketTo(ticketTo2);

                    buyer1.setTiketSeminar(tiketSeminar1);
                    buyer2.setTiketSeminar(tiketSeminar2);
                    

                    buyerService.save(buyer1);
                    buyerService.save(buyer2);

                    responseDTO.setUsername1(ticketTo1.getUsername());
                    responseDTO.setUsername2(ticketTo2.getUsername());
                    responseDTO.setPassword1(ticketTo1.getUsername());
                    responseDTO.setPassword2(ticketTo2.getUsername());
                }else if(requestDTO.getJenisOrder().contains("to")){
                    System.out.println("masuk to");
                    TiketTo ticketTo1 = tiketService.createTiketTo(buyer1);
                    TiketTo ticketTo2 = tiketService.createTiketTo(buyer2);

                    buyer1.setTiketTo(ticketTo1);
                    buyer2.setTiketTo(ticketTo2);

                    buyerService.save(buyer1);
                    buyerService.save(buyer2);

                    responseDTO.setUsername1(ticketTo1.getUsername());
                    responseDTO.setUsername2(ticketTo2.getUsername());
                    responseDTO.setPassword1(ticketTo1.getUsername());
                    responseDTO.setPassword2(ticketTo2.getUsername());
                }else if(requestDTO.getJenisOrder().contains("seminar")){
                    System.out.println("masuk seminar");
                    TiketSeminar tiketSeminar1 = tiketService.createTiketSeminar(buyer1);
                    TiketSeminar tiketSeminar2 = tiketService.createTiketSeminar(buyer2);

                    buyer1.setTiketSeminar(tiketSeminar1);
                    buyer2.setTiketSeminar(tiketSeminar2);
                    
                    buyerService.save(buyer1);
                    buyerService.save(buyer2);
                }

                order.setBuyer1(buyer1);
                order.setBuyer2(buyer2);
                
            }else{
                System.out.println("masuk not bundle");
                Buyer buyer = buyerService.findByNoHp(requestDTO.getNoHp1());
                if(buyer == null){
                    buyer = buyerService.createBuyer(requestDTO.getNama1(), requestDTO.getEmail1(), requestDTO.getNoHp1(), requestDTO.getAsalSekolah1());
                }

                responseDTO.setEmail1(buyer.getEmail());
                responseDTO.setNoHp1(buyer.getNoHp());

                System.out.println("\n\n\n\nasal");
                System.out.println(requestDTO.getAsalSekolah1());
                buyerService.save(buyer);

                if(requestDTO.getJenisOrder().contains("to-seminar")){
                    System.out.println("masuk to-seminar");
                    TiketTo ticketTo = tiketService.createTiketTo(buyer);
                    TiketSeminar tiketSeminar = tiketService.createTiketSeminar(buyer);

                    buyer.setTiketTo(ticketTo);
                    buyer.setTiketSeminar(tiketSeminar);

                    buyerService.save(buyer);

                    responseDTO.setUsername1(ticketTo.getUsername());
                    responseDTO.setPassword1(ticketTo.getUsername());

                }else if(requestDTO.getJenisOrder().contains("to")){
                    System.out.println("masuk to");
                    TiketTo ticketTo = tiketService.createTiketTo(buyer);

                    buyer.setTiketTo(ticketTo);
                    buyerService.save(buyer);

                    responseDTO.setUsername1(ticketTo.getUsername());
                    responseDTO.setPassword1(ticketTo.getUsername());

                }else if(requestDTO.getJenisOrder().contains("seminar")){
                    System.out.println("masuk seminar");
                    TiketSeminar tiketSeminar = tiketService.createTiketSeminar(buyer);

                    buyer.setTiketSeminar(tiketSeminar);
                    buyerService.save(buyer);
                }

                order.setBuyer1(buyer);
            }
            System.out.println("Saving Order...");
            orderDb.save(order);
            System.out.println("Order Saved!");
            System.out.println(order.getJenisOrder());
            System.out.println(responseDTO.getUsername1());
            System.out.println(responseDTO.getEmail1());
            System.out.println(responseDTO.getNoHp1());
            return responseDTO;

        } catch (Exception e) {
            ResponseCreateOrderDTO responseDTO = null;
            System.out.println(e.getMessage());
            return responseDTO;
        }
    }

    public ResponseBuyerDTO findByBuyer(Buyer buyer){
        return buyerService.buyerToDTO(buyerService.findById(buyer.getId()));
    }

    public Page<ResponseOrderDTO> findAllDtoPaginated(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> orderPage = orderDb.findAll(pageable);
        return orderPage.map(this::orderToDTO);
    }


    public ResponseOrderDTO findByBuyerEmail(String email){
        for(Order order:orderDb.findAll()){
            if(order.getBuyer1() != null && order.getBuyer1().getEmail().equals(email)){
                return orderToDTO(order);
            }else if(order.getBuyer2() != null && order.getBuyer2().getEmail().equals(email)){
                return orderToDTO(order);
            }
        }
        return null;
    }

    public Order processOrder(int id){
        for(Order order : orderDb.findAll()){
            if(order.getId() == id){
                order.setStatusPembayaran("Pembayaran berhasil di konfirmasi");
                if(order.getBuyer1().getTiketTo()!=null){
                    order.getBuyer1().getTiketTo().setStatus("Pembayaran berhasil di konfirmasi");
                    tiketService.save(order.getBuyer1().getTiketTo());
                }
                if(order.getBuyer1().getTiketSeminar()!=null){
                    order.getBuyer1().getTiketSeminar().setStatus("Pembayaran berhasil di konfirmasi");
                    tiketService.save(order.getBuyer1().getTiketSeminar());
                }
                if(order.getBuyer1() != null){
                    buyerService.save(order.getBuyer1());
                }
                
                if(order.getBuyer2().getTiketTo()!=null){
                    order.getBuyer2().getTiketTo().setStatus("Pembayaran berhasil di konfirmasi");
                    tiketService.save(order.getBuyer2().getTiketTo());
                }
                if(order.getBuyer2().getTiketSeminar()!=null){
                    order.getBuyer2().getTiketSeminar().setStatus("Pembayaran berhasil di konfirmasi");
                    tiketService.save(order.getBuyer2().getTiketSeminar());
                }
                if(order.getBuyer2() != null){
                    buyerService.save(order.getBuyer2());
                }

                return orderDb.save(order);
            }
        }
        return null;
    }

    public ArrayList<ResponseOrderDTO> findAllDto(){
        ArrayList<ResponseOrderDTO> listOrder = new ArrayList<>();
        for(Order order : orderDb.findAll()){
            listOrder.add(orderToDTO(order));
        }
        return listOrder;
    }

    public ResponseBuyerDTO findBuyerLogin(String email){
        return buyerService.findBuyerByLogin(email);
    }

    public ResponseTiketTo findTiketToByEmail(String email){
        return tiketService.getTiketToByEmail(email);
    }

    public ResponseTiketSeminar findTiketSeminarByEmail(String email){
        return tiketService.getTiketSeminarByEmail(email);
    }

    public ResponseOrderDTO orderToDTO(Order order){
        ResponseOrderDTO dto = new ResponseOrderDTO();
        dto.setBukti(order.getBukti());
        dto.setBuyer1(buyerService.buyerToDTO(order.getBuyer1()));
        dto.setBuyer2(buyerService.buyerToDTO(order.getBuyer2()));
        dto.setId(order.getId());
        dto.setJenisOrder(order.getJenisOrder());
        dto.setNominal(order.getNominal());
        dto.setStatusPembayaran(order.getStatusPembayaran());
        if(order.getBuyer1() != null){
            if(order.getBuyer1().getTiketSeminar() != null){
                dto.setTiketSeminar1(tiketService.tiketToDTO(order.getBuyer1().getTiketSeminar()));
            }
            if(order.getBuyer1().getTiketTo() != null){
                dto.setTiketTo1(tiketService.tiketToDTO(order.getBuyer1().getTiketTo()));
            }
        }

        if(order.getBuyer2() != null){
            if(order.getBuyer2().getTiketSeminar() != null){
                dto.setTiketSeminar2(tiketService.tiketToDTO(order.getBuyer2().getTiketSeminar()));
            }
            if(order.getBuyer2().getTiketTo() != null){
                dto.setTiketTo2(tiketService.tiketToDTO(order.getBuyer2().getTiketTo()));
            }
        }
        return dto;
    }
}
