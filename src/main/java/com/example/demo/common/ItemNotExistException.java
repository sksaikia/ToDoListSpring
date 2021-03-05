package com.example.demo.common;

public class ItemNotExistException extends IllegalArgumentException {
    public ItemNotExistException(String msg) {
        super(msg);
    }
}
