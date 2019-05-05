package com.bestboke.forkjoin.WordsCount;

import java.util.concurrent.RecursiveTask;

public class DocumentSearchTask extends RecursiveTask<Long> {

    private final Document document;
    private final String searchedWord;

    private WordCounter wordCounter = new WordCounter();

    public DocumentSearchTask(Document document, String searchedWord) {
        super();
        this.document = document;
        this.searchedWord = searchedWord;
    }

    @Override
    protected Long compute() {
        return wordCounter.occurrencesCount(document,searchedWord);
    }
}
