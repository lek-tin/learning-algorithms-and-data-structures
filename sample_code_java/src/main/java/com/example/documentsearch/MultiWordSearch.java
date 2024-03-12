package com.example.documentsearch;

import java.util.List;

public class MultiWordSearch extends SingleWordSearch {

    public MultiWordSearch(List<Document> documents) {
        super(documents);
        //TODO Auto-generated constructor stub
    }
    // add cache 

    // doc_1: alice bob charlie
    // doc_2: alice apple banana bob
    // inverted index:
    // [docId, index]
    // alice: [1, 0], [2, 0]
    // bob: [1, 1], [2, 3]
    // charlis: [1, 2]
    // apple: [2, 1]
    // banana: [2, 2]
}