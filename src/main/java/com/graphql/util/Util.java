package com.graphql.util;

import java.util.HashMap;
import java.util.Map;

public class Util {

    public static Integer getQuoteNumber(String quoteId) {
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("a279e697-7048-4d5c-8ab4-d5f95b72f6fa", 1);
            params.put("aa9dccd5-2713-4549-b577-9e728fcfc3ad", 2);


            return params.get(quoteId);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String getContactNumber(String quoteId) {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("a279e697-7048-4d5c-8ab4-d5f95b72f6fa", "8004165043");
            params.put("aa9dccd5-2713-4549-b577-9e728fcfc3ad", "9398130143");


            return params.get(quoteId);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
