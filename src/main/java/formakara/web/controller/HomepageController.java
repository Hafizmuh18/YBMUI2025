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
        jadwal5.put("image", "file/imma.JPG");
        listEvent.add(jadwal5);

        HashMap<String, String> jadwal6 = new HashMap<>();
        jadwal6.put("id", "5");
        jadwal6.put("sekolah", "SMA 4 Pontianak");
        jadwal6.put("tanggal", "Rabu, 8 Januari 2025");
        jadwal6.put("jam", "11.00-11.45");
        jadwal6.put("warna", "hijau");
        jadwal6.put("image", "file/tetra.JPG");
        listEvent.add(jadwal6);

        HashMap<String, String> jadwal7 = new HashMap<>();
        jadwal7.put("id", "6");
        jadwal7.put("sekolah", "MAN 1 Pontianak");
        jadwal7.put("tanggal", "Rabu, 8 Januari 2025");
        jadwal7.put("jam", "14.00");
        jadwal7.put("warna", "hijau");
        jadwal7.put("image", "file/man1.jpg");
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

        HashMap<String, String> jadwal13 = new HashMap<>();
        jadwal13.put("id", "12");
        jadwal13.put("sekolah", "SMA 1 Mempawah");
        jadwal13.put("tanggal", "Selasa, 14 Januari 2025");
        jadwal13.put("jam", "07.00");
        jadwal13.put("warna", "kuning");
        jadwal13.put("image", "file/comming_soon.png");
        listEvent.add(jadwal13);

        HashMap<String, String> jadwal14 = new HashMap<>();
        jadwal14.put("id", "13");
        jadwal14.put("sekolah", "MAN IC SAMBAS");
        jadwal14.put("tanggal", "Kamis, 16 Januari 2025");
        jadwal14.put("jam", "13.00");
        jadwal14.put("warna", "kuning");
        jadwal14.put("image", "file/comming_soon.png");
        listEvent.add(jadwal14);

        HashMap<String, String> jadwal15 = new HashMap<>();
        jadwal15.put("id", "14");
        jadwal15.put("sekolah", "SMA 1 SAMBAS");
        jadwal15.put("tanggal", "Sabtu, 18 Januari 2025");
        jadwal15.put("jam", "09.00");
        jadwal15.put("warna", "kuning");
        jadwal15.put("image", "file/comming_soon.png");
        listEvent.add(jadwal15);

        HashMap<String, String> jadwal16 = new HashMap<>();
        jadwal16.put("id", "15");
        jadwal16.put("sekolah", "SMAN 2 Pontianak");
        jadwal16.put("tanggal", "Senin, 20 Januari 2025");
        jadwal16.put("jam", "08.30-10.00");
        jadwal16.put("warna", "kuning");
        jadwal16.put("image", "file/comming_soon.png");
        listEvent.add(jadwal16);

        HashMap<String, String> jadwal17 = new HashMap<>();
        jadwal17.put("id", "15");
        jadwal17.put("sekolah", "EXPO SMAN 10 Pontianak");
        jadwal17.put("tanggal", "Rabu, 22 Januari 2025");
        jadwal17.put("jam", "08.30");
        jadwal17.put("warna", "kuning");
        jadwal17.put("image", "file/comming_soon.png");
        listEvent.add(jadwal17);

        model.addAttribute("listEvent", listEvent);

        return "roadshow";
    }
}
