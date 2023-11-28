# String Alignment Coding Task

## Introduction

This project is designed to showcase the implementation of a Java method that re-inserts HTML tags
into a string at suitable positions. The task involves creating a method that takes two input
strings and outputs a string with HTML elements from the first input string inserted into the
second input string at appropriate positions.

## Thought Process

explaining and elaborating how solved this challenge, thought process, assumptions, decisions, thoughts and comments, is in a [thought-process.md](doc/thought-process.md)  file.

## Prerequisites
- Java Development Kit (JDK) 17.
- Maven 3.9.2.

## Setup and Installation
1. Clone this repository to your local machine using Git.`git clone https://github.com/Samira1462/string-alignment.git`
2. Navigate to the project directory.
3. Run `mvn clean install` to build the project and run all tests.
4. Execute `mvn exec:java -Dexec.mainClass="com.codechallenge.htmlreplacment.Main" -Dexec.args="'<p>This very <i>loooong</i> text, which includes a <b>lot</b> of useless information, is not easy to understand.</p>' 'This long text includes a lot of information. It is not easy to understand.'"`


## Testing
- Unit tests are provided to check the functionalities.
- Run tests using `mvn test`.