package formakara.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import formakara.web.dto.request.RequestCreateOrderDTO;
import formakara.web.dto.request.RequestLoginDTO;
import formakara.web.dto.response.ResponseBuyerDTO;
import formakara.web.dto.response.ResponseCreateOrderDTO;
import formakara.web.dto.response.ResponseOrderDTO;
import formakara.web.dto.response.ResponseTiketSeminar;
import formakara.web.dto.response.ResponseTiketTo;
import formakara.web.models.Buyer;
import formakara.web.models.Order;
import formakara.web.repository.BuyerDb;
import formakara.web.repository.TiketSeminarDb;
import formakara.web.repository.TiketToDb;
import formakara.web.service.EmailService;
import formakara.web.service.OrderService;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private EmailService emailService;

    @Autowired
    BuyerDb buyerDb;

    @Autowired
    TiketToDb tiketToDb;

    @Autowired
    TiketSeminarDb tiketSeminarDb;
    
    @GetMapping("/order")
    public String orderForm(Model model){
        RequestCreateOrderDTO orderDTO = new RequestCreateOrderDTO();
        Map<String, Integer> mapHarga = new HashMap<>();
        mapHarga.put("bundle to-seminar", 100000);
        mapHarga.put("bundle to", 60000);
        mapHarga.put("bundle seminar", 40000);
        mapHarga.put("to-seminar", 55000);
        mapHarga.put("to", 35000);
        mapHarga.put("seminar", 25000);
        model.addAttribute("mapHarga", mapHarga);
        model.addAttribute("orderDTO", orderDTO);
        return "order";
    }

    @PostMapping("/order")
    public String submitOrder(@ModelAttribute("orderDTO") RequestCreateOrderDTO orderDTO, Model model){
        boolean invalid = false;
        String error = "";
        System.out.println("\n\n\n");
        System.out.println(orderDTO.getAsalSekolah1());
        System.out.println(orderDTO.getJenisOrder());
        System.out.println(orderDTO.getEmail1());
        for(Buyer buyer : buyerDb.findAll()){
            System.out.println("\n\n\n");
            System.out.println("buyer :"+buyer.getEmail());
            System.out.println("\n\n\n");
            System.out.println("order:"+orderDTO.getEmail1());
            if(orderDTO.getEmail1()!=null && buyer.getEmail().equalsIgnoreCase(orderDTO.getEmail1())){
                invalid = true;
                error = "Email "+orderDTO.getEmail1()+" sudah terdaftar";
            }else if(orderDTO.getNoHp1()!=null&&buyer.getNoHp().equalsIgnoreCase(orderDTO.getNoHp1())){
                invalid = true;
                error = "No HP "+orderDTO.getNoHp1()+" sudah terdaftar";
            }else if(orderDTO.getEmail2()!=null&&buyer.getEmail().equalsIgnoreCase(orderDTO.getEmail2())){
                invalid = true;
                error = "Email 2"+orderDTO.getEmail2()+" sudah terdaftar";
            }else if(orderDTO.getNoHp2()!=null&&buyer.getNoHp().equalsIgnoreCase(orderDTO.getNoHp2())){
                invalid = true;
                error = "No HP "+orderDTO.getNoHp2()+" sudah terdaftar";
            }

            if(invalid){
                model.addAttribute("error", error);
                return "invalid-response";
            }
        }
        
        ResponseCreateOrderDTO responseDTO = orderService.createOrder(orderDTO);

        model.addAttribute("order", responseDTO);
        return "response-order";
    }

    @GetMapping("/order/confirm/{id}")
    public String confirmPembayaran(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        try {
            Order order = orderService.processOrder(id);
            if (order == null) {
                redirectAttributes.addFlashAttribute("message", "Order gagal di update");
            }
            redirectAttributes.addFlashAttribute("isAdmin", true);
            return "redirect:/admin-console";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "403";
        }
    }


    @GetMapping("/login")
    public String formLogin(Model model){
        RequestLoginDTO loginDTO = new RequestLoginDTO();
        model.addAttribute("loginDTO", loginDTO);
        return "form-login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginDTO") RequestLoginDTO loginDTO, Model model, RedirectAttributes redirectAttributes) {
        if (loginDTO.getEmail().equals("adminhafiz")) {
            redirectAttributes.addFlashAttribute("isAdmin", true);
            return "redirect:/admin-console";
        }else{
            ResponseBuyerDTO buyer = orderService.findBuyerLogin(loginDTO.getEmail());
            if(buyer == null){
                return "403";
            }
            ResponseTiketSeminar tiketSeminar = orderService.findTiketSeminarByEmail(buyer.getEmail());
            ResponseTiketTo tiketTo = orderService.findTiketToByEmail(buyer.getEmail());
            ResponseOrderDTO order = orderService.findByBuyerEmail(buyer.getEmail());

            model.addAttribute("statusPembayaran", order.getStatusPembayaran());
            model.addAttribute("buyerDTO", buyer);
            model.addAttribute("tiketTo", tiketTo);
            model.addAttribute("tiketSeminar", tiketSeminar);
        
            return "user-detail";
        }
    }

    @GetMapping("/admin-console")
    public String adminConsole(@ModelAttribute("isAdmin") Boolean isAdmin, Model model) {
        if (isAdmin != null && isAdmin) {
            int totalTo = tiketToDb.findAll().size();
            int totalSeminar = tiketSeminarDb.findAll().size();
            ArrayList<ResponseOrderDTO> listOrder = orderService.findAllDto();
            model.addAttribute("tiketTo", totalTo);
            model.addAttribute("tiketSeminar", totalSeminar);
            model.addAttribute("listOrder", listOrder);
            return "console";
        }
        model.addAttribute("errorMessage", "403 - Forbidden: You are not authorized to access this page.");
        return "error-403";
    }
}
