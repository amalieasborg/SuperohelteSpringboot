package org.example.superoheltespringboot.Service;

import org.example.superoheltespringboot.Model.MarvelCharacter;
import org.example.superoheltespringboot.Repository.MarvelCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarvelCharacterService {
    @Autowired
    MarvelCharacterRepository characterRepository;

    public MarvelCharacterService(MarvelCharacter marvelCharacter){
        characterRepository.save(marvelCharacter);
    }

}
