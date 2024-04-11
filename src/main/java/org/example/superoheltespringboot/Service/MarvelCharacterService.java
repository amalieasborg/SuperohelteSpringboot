package org.example.superoheltespringboot.Service;

import org.example.superoheltespringboot.Model.MarvelCharacter;
import org.example.superoheltespringboot.Repository.MarvelCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarvelCharacterService {
    @Autowired
    MarvelCharacterRepository characterRepository;

    public void saveMarvelCharacter(MarvelCharacter marvelCharacter){
        characterRepository.save(marvelCharacter);
    }
    public List<MarvelCharacter> findAllMarvelCharacters(){
        return characterRepository.findAll();
    }
    public Optional findById(Long id){
        return Optional.ofNullable(characterRepository.findById(id));
    }
    public void deleteMarvelcharacterById(Long id){
        characterRepository.delete(id);
    }

}
