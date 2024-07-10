package com.JavaTestTask.enuns;

public enum FileProcessorEnum {

    CSV,
    EXCEL;

    public static FileProcessorEnum toValidExtension(String extension) {
        switch (extension.toLowerCase()) {
            case "csv":
                return CSV;
            case "xlsx", "xls":
                return EXCEL;
            default:
                throw new IllegalArgumentException("Unsupported file type: " + extension);
        }
    }
}
