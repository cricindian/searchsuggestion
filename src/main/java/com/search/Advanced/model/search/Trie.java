package com.search.Advanced.model.search;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Trie {
    private static TrieNode root = new TrieNode();

    // Insert all the Contacts into the Trie
    public List<String> insertIntoTrie(List<String> contacts) {
//        root = new TrieNode();
        List<String> invalidContact = new ArrayList<>();
        for (String contact : contacts) {
            if(contact.length() > 10)
            {
                invalidContact.add(contact);
                continue;
            }
            insert(contact);
        }

        return invalidContact;
    }

    // Insert a Contact into the Trie
    public void insert(String s) {
        int len = s.length();

        // 'itr' is used to iterate the Trie Nodes
        TrieNode itr = root;
        for (int i = 0; i < len; i++) {
            // Check if the s[i] is already present in
            // Trie
            TrieNode nextNode = itr.child.get(s.charAt(i));
            if (nextNode == null) {
                // If not found then create a new TrieNode
                nextNode = new TrieNode();

                // Insert into the HashMap
                itr.child.put(s.charAt(i), nextNode);
            }

            // Move the iterator('itr') ,to point to next
            // Trie Node
            itr = nextNode;

            // If its the last character of the string 's'
            // then mark 'isLast' as true
            if (i == len - 1)
                itr.isLast = true;
        }
    }

    // This function simply displays all dictionary words
    // going through current node.  String 'prefix'
    // represents string corresponding to the path from
    // root to curNode.
    public List<String> displayContactsUtil(TrieNode curNode,
                                            String prefix , List<String> suggestionList) {

        // Check if the string 'prefix' ends at this Node
        // If yes then display the string found so far
        if (curNode.isLast)
            suggestionList.add(prefix);

        // Find all the adjacent Nodes to the current
        // Node and then call the function recursively
        // This is similar to performing DFS on a graph
        for (char i = 'a'; i <= 'z'; i++) {
            TrieNode nextNode = curNode.child.get(i);
            if (nextNode != null) {
                displayContactsUtil(nextNode, prefix + i,suggestionList);
            }
        }
        return suggestionList;
    }

    // Display suggestions after every character enter by
    // the user for a given string 'str'
    public Map<String, List<String>> getSuggestionList(String str) {
        TrieNode prevNode = root;

        Map<String, List<String>> map = new LinkedHashMap<>();

        // 'flag' denotes whether the string entered
        // so far is present in the Contact List

        String prefix = "";
        int len = str.length();

        // Display the contact List for string formed
        // after entering every character
        int i;
        for (i = 0; i < len; i++) {

            List<String> suggestionList = new ArrayList<>();
            // 'str' stores the string entered so far
            prefix += str.charAt(i);

            // Get the last character entered
            char lastChar = prefix.charAt(i);
            map.put(prefix, suggestionList);
            // Find the Node corresponding to the last
            // character of 'str' which is pointed by
            // prevNode of the Trie
            TrieNode curNode = prevNode.child.get(lastChar);

            // If nothing found, then break the loop as
            // no more prefixes are going to be present.
            if (curNode == null) {
                i++;
                break;
            }

            // If present in trie then display all
            // the contacts with given prefix.
            displayContactsUtil(curNode, prefix, suggestionList);


            // Change prevNode for next prefix
            prevNode = curNode;
        }

        return map;
    }
}