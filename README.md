### Setting up the project

1. clone the repo using following command
```textmate
    git clone https://github.com/cricindian/searchsuggestion.git
```
2. import the project in intellij as a ``maven`` project
3. Run the main SearchApplication.java
4. Application will start on 9000 port
5. /api/v1/search , is mapped for contact auto complete  
6. /api/v1/palindrome , is mapped to access the largest palindrome for a given string.

## Search Suggestion OR AutoComplete
```textmate
Trie DS is used to store all the contacts, helps in suggesting autocomplete in search.

TrieNode has a child HashMap<Character , TrieNode> and isLast to identify last character.
Each HashMap stores 1. n number of key characters with 2. TrieNode value which inturn stores above 2
This forms a tree of words linked by a character at each level until leaf node.

We find all possible words that can be suggested by doing DFS on this tree.

```

## EndPoints

### Insert Contacts in bulk
```textmate
POST /search/addSuggestions
```

##### Curl Request
```curl
curl --location --request POST 'http://localhost:9000/api/v1/search/addSuggestions' \
--header 'Content-Type: application/json' \
--data-raw '["Santosh", "sanket"]'
```

##### Post body
```json
["Santosh", "sanket"]
```

##### Response 
```json
201 Created (All contacts are added to contact book)
202 Accepted (Some contacts are not added , because of length constraint which is < 10)
```


### Get Search suggestion
```textmate
GET /search/suggest/{contact}
```

##### Curl Request
```textmate
curl --location --request GET 'http://localhost:9000/api/v1/search/suggest/sa'
```

##### Response 
```json
{
    "s": [
        "sanket",
        "santosh"
    ],
    "sa": [
        "sanket",
        "santosh"
    ]
}
```
------------------------------------------------------------------
------------------------------------------------------------------
------------------------------------------------------------------
------------------------------------------------------------------
------------------------------------------------------------------
## Find the largest Palindrome from given line of string

```textmate
considering single mid point for string with odd length.
considering two character, at position i & i+1 as mid point for string with even length.
expanding from mid towards start and end until  characters from mid towards left and right are matching && mid stays with in string length bounderis.
we get low , and high points in the string, which is a substring palindrome. We repeat this process until we find a max palindrome string.
```

## EndPoints

### Get Search suggestion
```textmate
GET /palindrome/largestPalindrome/{line}
```

##### Curl Request
```textmate
curl --location --request GET 'http://localhost:9000/api/v1/palindrome/largestPalindrome/HelloWelcomeemoclewHelloolle'
```

##### Response 
```json
Welcomeemoclew
```
