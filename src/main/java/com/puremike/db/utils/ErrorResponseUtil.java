package com.puremike.db.utils;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponseUtil {

    private ErrorResponseUtil() {

    }

    public static Map<String, String> createNotFoundResponse(String resourceType, Long id) {
        Map<String, String> errorResponse = new HashMap<>();
        String message = String.format("%s with ID %d not found", resourceType, id);
        errorResponse.put("message", message);
        return errorResponse;
    }

    public static Map<String, String> createNotFoundResponse(String resourceType, String isbn) {
        Map<String, String> errorResponse = new HashMap<>();
        String message = String.format("%s with ISBN %s not found", resourceType, isbn);
        errorResponse.put("message", message);
        return errorResponse;
    }

    public static Map<String, String> createFailedResponse(String resourceType) {
        Map<String, String> errorResponse = new HashMap<>();
        String message = String.format("failed to create %s", resourceType);
        errorResponse.put("message", message);
        return errorResponse;
    }
}
