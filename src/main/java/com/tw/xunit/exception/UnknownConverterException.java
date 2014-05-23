package com.tw.xunit.exception;

public class UnknownConverterException extends Exception {
    public UnknownConverterException(String converterId) {
        super("Unknown converter: " + converterId);
    }
}
