package com.bestboke.forkjoin.WordsCount;


public class WordCounter {

    String[] wordsIn(String line){
        return line.trim().split("(\\s|\\p{Punct})+");
    }

    public Long occurrencesCount(Document document, String searchedWord){
        Long count = 0L;
        for (String line : document.getLines()){
            for (String word : wordsIn(line)){
                if (searchedWord.equals(word)){
                    count ++;
                    System.out.println(line);
                }
            }
        }
        return count;
    }

}



