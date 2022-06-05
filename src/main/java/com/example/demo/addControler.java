package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class addControler {
    private FilmRepo filmRepo;
    @Autowired
    public addControler(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }

    @RequestMapping("/formularz")
    public String Dodanie(){
        return "Formularz";
    }

    @RequestMapping("/dodaj")
    public String dodajemyDane(
            @RequestParam("nazwa") String nazwa,
            @RequestParam("data") String data,
            @RequestParam("gatunek") String gatunek,
            @RequestParam("dlugosc") String dlugosc,
            @RequestParam("ocena") String ocena,
            @RequestParam("kategoria") String kategoria, Model model)
            throws Exception {
            Film film = new Film(nazwa, data, gatunek, dlugosc, ocena, kategoria, true);
        System.out.println(film);
        filmRepo.save(film); // ZAPIS
        model.addAttribute("film", film);
        return "pokaz";
    }

    @RequestMapping("/pokaz")
    public String pokaz(Model model){
        for(Film film : filmRepo.findAll()){
            System.out.println(film);
        }
        model.addAttribute("film", filmRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/kasuj")
    public String kasuj(@RequestParam("id") Integer id, Model model){
        filmRepo.deleteById(id);

        model.addAttribute("film", filmRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/wyszukaj")
    public String wyszukaj(@RequestParam("nazwa") String nazwa, Model model){
        model.addAttribute("film", filmRepo.findAllBynazwa(nazwa));
        return "pokaz";
    }

    @RequestMapping("/przekieruj")
    public String przekieruj(
            @RequestParam("id") Integer id, Model model
    )
            throws Exception {
        System.out.println(filmRepo.findById(id));
        model.addAttribute("film", filmRepo.findById(id));
        return "aktualizuj";
    }

    @RequestMapping("/aktualizuj")
    public String update(
            @RequestParam("id") Integer id,
            @RequestParam("nazwa") String nazwa,
            @RequestParam("data") String data,
            @RequestParam("gatunek") String gatunek,
            @RequestParam("dlugosc") String dlugosc,
            @RequestParam("ocena") String ocena,
            @RequestParam("kategoria") String kategoria, Model model)
            throws Exception {
        Film film = new Film(id, nazwa, data, gatunek, dlugosc, ocena, kategoria, true);
        System.out.println(film);
        filmRepo.save(film);
        model.addAttribute("film", film);
        return "pokaz";
    }
}