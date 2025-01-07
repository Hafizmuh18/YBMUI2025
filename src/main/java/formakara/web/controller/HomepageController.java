package formakara.web.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {
    @GetMapping("/")
    public String homepage(Model model){
        
        return "homepage";
    }

    @GetMapping("/roadshow")
    public String roadshow(Model model){
        ArrayList<HashMap<String, String>> listEvent = new ArrayList<>();

        HashMap<String, String> jadwal1 = new HashMap<>();
        jadwal1.put("id", "0");
        jadwal1.put("sekolah", "SMA AL-FITYAN");
        jadwal1.put("tanggal", "Senin, 6 Januari 2025");
        jadwal1.put("jam", "08.30");
        jadwal1.put("warna", "hijau");
        jadwal1.put("image", "file/alfityan.jpg");
        listEvent.add(jadwal1);

        HashMap<String, String> jadwal2 = new HashMap<>();
        jadwal2.put("id", "1");
        jadwal2.put("sekolah", "SMA 3 Pontianak");
        jadwal2.put("tanggal", "Senin, 6 Januari 2025");
        jadwal2.put("jam", "09.40-11.00");
        jadwal2.put("warna", "hijau");
        jadwal2.put("image", "file/smanta.jpg");
        listEvent.add(jadwal2);

        HashMap<String, String> jadwal3 = new HashMap<>();
        jadwal3.put("id", "2");
        jadwal3.put("sekolah", "SMA AL-AZHAR");
        jadwal3.put("tanggal", "Selasa, 7 Januari 2025");
        jadwal3.put("jam", "10.16-11.00");
        jadwal3.put("warna", "hijau");
        jadwal3.put("image", "file/alazhar.jpg");
        listEvent.add(jadwal3);

        HashMap<String, String> jadwal4 = new HashMap<>();
        jadwal4.put("id", "3");
        jadwal4.put("sekolah", "SMA 8 Pontianak");
        jadwal4.put("tanggal", "Selasa, 7 Januari 2025");
        jadwal4.put("jam", "12.00-14.00");
        jadwal4.put("warna", "hijau");
        jadwal4.put("image", "file/smandel.jpg");
        listEvent.add(jadwal4);

        HashMap<String, String> jadwal5 = new HashMap<>();
        jadwal5.put("id", "4");
        jadwal5.put("sekolah", "SMA Immanuel");
        jadwal5.put("tanggal", "Rabu, 8 Januari 2025");
        jadwal5.put("jam", "08.00-08.30");
        jadwal5.put("warna", "hijau");
        jadwal5.put("image", "file/comming_soon.png");
        listEvent.add(jadwal5);

        HashMap<String, String> jadwal6 = new HashMap<>();
        jadwal6.put("id", "5");
        jadwal6.put("sekolah", "SMA 4 Pontianak");
        jadwal6.put("tanggal", "Rabu, 8 Januari 2025");
        jadwal6.put("jam", "11.00-11.45");
        jadwal6.put("warna", "hijau");
        jadwal6.put("image", "file/comming_soon.png");
        listEvent.add(jadwal6);

        HashMap<String, String> jadwal7 = new HashMap<>();
        jadwal7.put("id", "6");
        jadwal7.put("sekolah", "MAN 1 Pontianak");
        jadwal7.put("tanggal", "Rabu, 8 Januari 2025");
        jadwal7.put("jam", "14.00");
        jadwal7.put("warna", "hijau");
        jadwal7.put("image", "file/comming_soon.png");
        listEvent.add(jadwal7);

        HashMap<String, String> jadwal8 = new HashMap<>();
        jadwal8.put("id", "7");
        jadwal8.put("sekolah", "SMA 1 Pontianak");
        jadwal8.put("tanggal", "Kamis, 9 Januari 2025");
        jadwal8.put("jam", "08.35-15.15");
        jadwal8.put("warna", "hijau");
        jadwal8.put("image", "file/comming_soon.png");
        listEvent.add(jadwal8);

        HashMap<String, String> jadwal9 = new HashMap<>();
        jadwal9.put("id", "8");
        jadwal9.put("sekolah", "EXPO SMA 1 Pontianak");
        jadwal9.put("tanggal", "Jumat, 10 Januari 2025");
        jadwal9.put("jam", "08.35-15.15");
        jadwal9.put("warna", "kuning");
        jadwal9.put("image", "file/comming_soon.png");
        listEvent.add(jadwal9);

        HashMap<String, String> jadwal10 = new HashMap<>();
        jadwal10.put("id", "9");
        jadwal10.put("sekolah", "EXPO SMA 1 Pontianak");
        jadwal10.put("tanggal", "Sabtu, 11 Januari 2025");
        jadwal10.put("jam", "08.35-15.15");
        jadwal10.put("warna", "kuning");
        jadwal10.put("image", "file/comming_soon.png");
        listEvent.add(jadwal10);

        HashMap<String, String> jadwal11 = new HashMap<>();
        jadwal11.put("id", "10");
        jadwal11.put("sekolah", "SMA 1 Sungai Raya");
        jadwal11.put("tanggal", "Senin, 13 Januari 2025");
        jadwal11.put("jam", "-");
        jadwal11.put("warna", "orange");
        jadwal11.put("image", "file/comming_soon.png");
        listEvent.add(jadwal11);

        HashMap<String, String> jadwal12 = new HashMap<>();
        jadwal12.put("id", "11");
        jadwal12.put("sekolah", "EXPO SMA 1 Singkawang");
        jadwal12.put("tanggal", "Selasa, 14 Januari 2025");
        jadwal12.put("jam", "-");
        jadwal12.put("warna", "kuning");
        jadwal12.put("image", "file/comming_soon.png");
        listEvent.add(jadwal12);

        model.addAttribute("listEvent", listEvent);

        return "roadshow";
    }
}
