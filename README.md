![image](https://user-images.githubusercontent.com/45018986/152331467-b4ab6300-de3c-4e16-b34c-0e8154b4b7cc.png)

# duckduckgoTestFramework
Framework for Automation QA Tests of duckduckgo web site based Java language

Prepere steps: 

1. in CommonActions class set the path to your chromedriver.exe ( 96+ chrome browser version ).
2. in testng.xml file set the path to your duckduckgoTestFramework project folder

Implementation of the next test cases:

Case 1

   1. Go to https://duckduckgo.com/
   2. Select search text input
   3. Type word watermelons
   4. Validate that autocomplete dropdown has 8 elements

Case 2

   1. Go to https://duckduckgo.com/
   2. Select search text input
   3. Type word watermelons
   4. Submit the form – you get redirected to search results page
   5. Validate that there are 10 search results in left column and one result in right column

Case 3

   1. Go to https://duckduckgo.com/
   2. Select search text input
   3. Type word watermelons
   4. Submit the form – you get redirected to search results page
   5. Find “More results” button and click on it – you get more search results loadedу
   6. Validate that there total number of search results in left column is 20
   7. Validate that 10 original search result items in the left column are still there and didn’t change – by comparing content of h2 elements
