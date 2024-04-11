package org.example.superoheltespringboot.Controller;

import org.example.superoheltespringboot.Model.MarvelCharacter;
import org.example.superoheltespringboot.Service.MarvelCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MarvelCharacterController {
    private MarvelCharacterService characterService;

    @GetMapping("/")
    public String showAllMarvelCharacters(Model model){
        model.addAttribute("marvelcharacters",characterService.findAllMarvelCharacters());
        return "index";
    }
    @GetMapping("/")
    public String showOneMarvelCharacter(Model model,@PathVariable Long id){
        model.addAttribute("marvelcharacters",characterService.findById(id));
        return "index";
    }

    @PostMapping("/")
    public String saveMarvelCharacter(@ModelAttribute MarvelCharacter marvelCharacter){
        characterService.saveMarvelCharacter(marvelCharacter);
        return "redirect:/";
    }
    @DeleteMapping("/")
    public String deleteOneMarvelCharacter(@PathVariable Long id){
        characterService.deleteMarvelcharacterById(id);
        return "redirect:/";
    }


}
