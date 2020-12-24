package com.search.Advanced.service.search;

import lombok.AllArgsConstructor;
import com.search.Advanced.model.search.Trie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SearchService {
    private Trie trie ;
    public Map<String, List<String>> suggest(String prifix){
        return trie.getSuggestionList(prifix);
    }

    public List<String > insert(List<String> contacts){
        return trie.insertIntoTrie(contacts);
    }
}
