package com.search.Advanced.controller;

import com.search.Advanced.service.search.SearchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/search/")
@AllArgsConstructor
@Slf4j
public class SearchSuggestionController {

    private SearchService searchService;

    @GetMapping("suggest/{prefix}")
    public ResponseEntity<Map<String, List<String>>> suggest(@PathVariable String prefix){
        log.info(prefix);
        return new ResponseEntity<>(searchService.suggest(prefix), HttpStatus.OK);
    }

    @PostMapping("addSuggestions")
    public ResponseEntity<HttpStatus> addSuggestions(@RequestBody List<String> contacts){
        List<String> invalidContact = searchService.insert(contacts);
        if(invalidContact.isEmpty())
            return new ResponseEntity<>(HttpStatus.CREATED); // All the contacts are inserted
        else
            return new ResponseEntity<>(HttpStatus.ACCEPTED); // Contacts with length > 10 are ignored
    }
}
