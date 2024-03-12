package com.example.documentsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    List<Integer> documentIds;

    public TrieNode() {
        children = new HashMap<>();
        documentIds = new ArrayList<>();
    }

    public void print(String prefix) {
        System.out.println(prefix + "└── " + documentIds);
        for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
            entry.getValue().print(prefix + "    " + entry.getKey());
        }
    }
}

public class DocumentProcessor {
    private TrieNode root;
    private Map<String, List<Integer>> wordToDocIds;

    public DocumentProcessor() {
        root = new TrieNode();
        wordToDocIds = new HashMap<>();
    }

    public void buildTrieAndCache(List<String> documents) {
        for (int docId = 0; docId < documents.size(); docId++) {
            String document = documents.get(docId);
            String[] words = document.split("\\s+"); // Tokenize the document

            for (String word : words) {
                TrieNode current = root;

                // Insert the word into the trie
                for (char c : word.toCharArray()) {
                    current.children.putIfAbsent(c, new TrieNode());
                    current = current.children.get(c);
                }

                // Update the cache
                current.documentIds.add(docId);

                // Update wordToDocIds
                if (!wordToDocIds.containsKey(word)) {
                    wordToDocIds.put(word, new ArrayList<>());
                }
                wordToDocIds.get(word).add(docId);
            }
        }
    }

    public void printTrie() {
        root.print("");
    }

    public static void main(String[] args) {
        List<String> documents = new ArrayList<>();
        documents.add("This is a sample document.");
        documents.add("Another document.");
        documents.add("Sample text.");

        DocumentProcessor processor = new DocumentProcessor();
        processor.buildTrieAndCache(documents);

        // Visualize the trie structure
        processor.printTrie();
    }
}
