# Thought Process for String Alignment Coding Task

_Thought process here as described in the [Readme file](../README.md)._

## Objective


## Getting Started
To get started with the Backend Coding Challenge, follow these steps:

1. **Clone the Repository**
    ```sh 
   git clone https://github.com/Samira1462/string-alignment.git


## Roles
1. **Retain HTML Tags:** Preserve the positions of HTML tags from the first array (string) in the final output.
2. **Remove Unmatched Words:** Eliminate words present in the first array but not in the second.
3. **Insert New Words:** Include words that are in the second array but not in the first, in the correct position.
4. **Handle Punctuation Marks:** If a word in the second array ends with a punctuation mark, replace the corresponding word in the first array with this new word (including the punctuation).

## Step-by-Step Process

### Step 1: Parse and Create Word Lists
- Parse the both string and Split both strings into words

### Step 2: Remove Unmatched Words and Insert New Words and Handle Punctuation
- Remove Unmatched Words (Normalize the word) and Insert New Words and Handle Punctuation

### Step 3: Construct Final Output
- Combine the words and HTML tags into a single string.
- This string should now align with the second string while retaining the HTML tags from the first string.

## Challenges and Considerations
- **Complexity of HTML Tag Parsing:** HTML tags can be nested and complex. Proper parsing is crucial.
- **Word Positioning:** Determining the correct position for new words can be challenging, especially in cases where the order significantly differs between the two strings.
- **Punctuation Handling:** Special attention is needed to ensure punctuation is correctly associated with the words.

## Conclusion
This document outlines the thought process for aligning two strings under specified constraints.
The implementation will require careful consideration of string manipulation, HTML parsing, and alignment logic.




