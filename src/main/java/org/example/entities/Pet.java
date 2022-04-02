package org.example.entities;

public class Pet {


    public static String getPet(){
        return "{\n" +
                "  \"id\": 101,\n" +
                "  \"category\": {\n" +
                "    \"id\": 101,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"Sarancha\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 101,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
    }
}
