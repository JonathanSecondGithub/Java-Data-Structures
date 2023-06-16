package com.apress.isf.java.service;
public interface SearchEngine {
    public List<Document> findByType(Type documentType);
    public List<Document> listAll();
}