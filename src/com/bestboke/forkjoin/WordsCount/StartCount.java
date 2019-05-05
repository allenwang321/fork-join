package com.bestboke.forkjoin.WordsCount;

import org.junit.Test;

import java.io.File;
import java.util.concurrent.ForkJoinPool;



public class StartCount {

    private final ForkJoinPool forkJoinPool = new ForkJoinPool();


    Long countOccurrencesInParallel(Folder folder, String searchedWord) {
        return forkJoinPool.invoke(new FolderSearchTask(folder, searchedWord));
    }

    @Test
    public void start() throws Exception{

        Folder folder = Folder.fromDirectory(new File("/Users/allen/"));
        System.out.println(countOccurrencesInParallel(folder, "allen"));
    }
}
