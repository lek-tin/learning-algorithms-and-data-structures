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

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    Set<Integer> documentIds = new HashSet<>();
}

public class PhraseSearch {
    private Map<String, List<Integer>> counterCache = new HashMap<>();
    private TrieNode root = new TrieNode();

    public PhraseSearch(List<Document> documents) {
        buildTrie(documents);
    }

    private void buildTrie(List<Document> documents) {
        for (Document document : documents) {
            int documentId = document.getId();
            String content = document.getContent().toLowerCase();

            TrieNode currentNode = root;

            for (char ch: content.toCharArray()) {
                currentNode = currentNode.children.computeIfAbsent(ch, k -> new TrieNode());
                currentNode.documentIds.add(documentId);
            }

            // String[] words = content.split("\\s+");
            // for (String word : words) {
            //     for (char c : word.toCharArray()) {
            //         currentNode = currentNode.children.computeIfAbsent(c, k -> new TrieNode());
            //         currentNode.documentIds.add(documentId);
            //     }
            // }
        }
    }

    public List<Integer> searchForString(String target) {
        target = target.toLowerCase();
        if (counterCache.containsKey(target)) return counterCache.get(target);

        TrieNode currentNode = root;

        for (char c : target.toCharArray()) {
            if (currentNode.children.containsKey(c)) {
                currentNode = currentNode.children.get(c);
            } else {
                return Collections.emptyList(); // No documents contain the target string
            }
        }

        Set<Integer> documentIds = currentNode.documentIds;
        return new ArrayList<>(documentIds);
    }

    public static void main(String[] args) {
        // Sample list of documents
        List<Document> documents = new ArrayList<>();
        documents.add(new Document(1, "This is the first document."));
        documents.add(new Document(2, "The second document contains a target."));
        documents.add(new Document(3, "Another document without the target."));
        documents.add(new Document(4, "This document has the target as well."));

        PhraseSearch searcher = new PhraseSearch(documents);

        String targetToSearch = "target";

        List<Integer> foundDocumentIds = searcher.searchForString(targetToSearch);

        if (foundDocumentIds.isEmpty()) {
            System.out.println("No documents contain the target string.");
        } else {
            System.out.println("Documents containing the target string:");
            for (Integer id : foundDocumentIds) {
                System.out.println("Document ID: " + id);
            }
        }

        foundDocumentIds = searcher.searchForString("without the target");

        if (foundDocumentIds.isEmpty()) {
            System.out.println("No documents contain the target string.");
        } else {
            System.out.println("Documents containing the target string:");
            for (Integer id : foundDocumentIds) {
                System.out.println("Document ID: " + id);
            }
        }
    }
}
