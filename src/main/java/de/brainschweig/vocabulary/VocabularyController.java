package de.brainschweig.vocabulary;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;

import de.brainschweig.vocabulary.entities.Vocable;
import de.brainschweig.vocabulary.exceptions.VocableNotFoundException;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/api/v1.0") // This means URL's start with /demo (after Application path)

public class VocabularyController {
    @Autowired
    private VocableRepository vocableRepository;

    // CREATE

    @PostMapping(path = "/vocabulary")
    public @ResponseBody String addNewVocable(@RequestParam String hanze, @RequestParam String pinyin,
            @RequestParam String german) {

        Vocable v = new Vocable();
        v.setHanze(hanze);
        v.setPinyin(pinyin);
        v.setGerman(german);
        return vocableRepository.save(v).toString();
    }

    // GET ALL

    @GetMapping(path = "/vocabulary")
    public @ResponseBody Iterable<Vocable> getAllVocables() {
        return vocableRepository.findAll();
    }

    // GET BY ID

    @GetMapping(path = "/vocabulary/{id}")
    public @ResponseBody Optional<Vocable> getOneVocable(@PathVariable("id") Integer id) {
        return vocableRepository.findById(id);
    }

    // DELETE BY ID

    @DeleteMapping("/vocabulary/{id}")
    public @ResponseBody Vocable deleteVocable(@PathVariable("id") Integer id) {
        try{
        vocableRepository.deleteById(id);
        } catch (IllegalArgumentException iae){
            return null;    
        }
        return new Vocable();
    }
}
