package com.search.Advanced.service.palindrome;

import com.search.Advanced.model.palindrome.LargestPalindrome;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PalindromeService {
    private LargestPalindrome largestPalindrome;

    public String findLargestPalindrome(String line)
    {
        return largestPalindrome.longestPalindrome(line);
    }
}
