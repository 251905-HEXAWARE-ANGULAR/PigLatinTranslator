package com.revature.PigLatinBackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
@CrossOrigin
public class PigLatinController {

    @PostMapping
    public ResponseEntity<String> translateToPigLatin(@RequestBody String input) {
        //Ripped directly from Github Copilot
        String[] words = input.split(" ");
        StringBuilder pigLatin = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                char firstLetter = word.charAt(0);
                String pigLatinWord = word.substring(1) + firstLetter + "ay";
                pigLatin.append(pigLatinWord).append(" ");
            }
        }

        return ResponseEntity.ok(pigLatin.toString().trim());
    }

}
