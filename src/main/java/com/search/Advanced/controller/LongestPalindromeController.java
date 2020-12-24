package com.search.Advanced.controller;

import com.search.Advanced.service.palindrome.PalindromeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/palindrome/")
@AllArgsConstructor
public class LongestPalindromeController {

    private PalindromeService palindromeService;

    @GetMapping("/largestPalindrome/{line}")
    public ResponseEntity<String> findLargestPalindrome(@PathVariable String line)
    {
        return new ResponseEntity<>(palindromeService.findLargestPalindrome(line), HttpStatus.OK);
    }
}
