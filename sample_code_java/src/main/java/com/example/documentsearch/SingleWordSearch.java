package com.example.documentsearch;

import java.util.*;

class Document {
    private int id;
    private String content;

    public Document(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

/**
This class utilizes an inverted index to search for words
It returns a list of document ids whose content contain the search word

Raw input:
doc1: "Today is a beautiful, and a sunny day to start my workout."
doc2: "I will not be able to come today to meet with him."
doc3: "Our class meeting starts soon!"
doc4: "My class starts at 6."
--------------------------------------------
tokenization:
doc1: ["today", "beautiful",
doc1: ["today", "beautiful", "sunny" "day", "start", "workout"]
doc2: ["come", "today", "meet"]
doc3: ["class", "meet", "start", "soon"]
doc4: ["class", "start"]
--------------------------------------------
inverted index:
today     : [doc1, doc2]
beautiful : [doc1]
sunny     : [doc1]
day       : [doc1]
start     : [doc1, doc3]
workout   : [doc1]
come      : [doc2]
meet      : [doc2, doc3]
class     : [doc3, doc4]
soon      : [doc3]

If
*/
public class SingleWordSearch {
    private Map<String, Set<Integer>> invertedIndex = new HashMap<>();

    public SingleWordSearch(List<Document> documents) {
        buildInvertedIndex(documents);
    }

    private void buildInvertedIndex(List<Document> documents) {
        for (Document document : documents) {
            int documentId = document.getId();
            String content = document.getContent().toLowerCase();
            String[] words = content.split("\\s+");

            for (String word : words) {
                word = word.replaceAll("[^a-zA-Z0-9]", ""); // Remove non-alphanumeric characters
                if (!word.isEmpty()) {
                    invertedIndex.computeIfAbsent(word, k -> new HashSet<>()).add(documentId);
                }
            }
        }
    }

    public Set<Integer> searchForWord(String word) {
        word = word.toLowerCase();
        return invertedIndex.getOrDefault(word, Collections.emptySet());
    }

    public static void main(String[] args) {
        // Sample list of documents
        List<Document> documents = new ArrayList<>();
        documents.add(new Document(1, "This is the first document."));
        documents.add(new Document(2, "The second document contains a word."));
        documents.add(new Document(3, "Another document without the word."));
        documents.add(new Document(4, "This document has the word as well."));

        SingleWordSearch searcher = new SingleWordSearch(documents);

        String wordToSearch = "word";

        Set<Integer> foundDocumentIds = searcher.searchForWord(wordToSearch);

        if (foundDocumentIds.isEmpty()) {
            System.out.println("No documents contain the word.");
        } else {
            System.out.println("Documents containing the word:");
            for (Integer id : foundDocumentIds) {
                System.out.println("Document ID: " + id);
            }
        }
    }
}
