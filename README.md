###Setting up the project

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
