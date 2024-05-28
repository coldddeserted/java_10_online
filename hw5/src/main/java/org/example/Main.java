package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        dictionary.put("One", 1);
        dictionary.put("Two", 2);
        System.out.println("Size: " + dictionary.size());
        System.out.println("Contains key 'One': " + dictionary.containsKey("One"));
        System.out.println("Contains value 2: " + dictionary.containsValue(2));
        System.out.println("Value for key 'Two': " + dictionary.get("Two"));
        dictionary.remove("One");
        System.out.println("Size after removing 'One': " + dictionary.size());
        Dictionary<String, Integer> anotherDictionary = new Dictionary<>();
        anotherDictionary.put("Three", 3);
        System.out.println("Put all from another dictionary: " + dictionary.putAll(anotherDictionary));
        System.out.println("Clear dictionary: " + dictionary.clear());
        System.out.println("Size after clearing: " + dictionary.size());
        dictionary.put("One", 1);
        dictionary.put("Two", 2);
        dictionary.put("Three", 3);
        System.out.println("Keys in dictionary: " + Arrays.toString(dictionary.keys()));
        System.out.println("Values in dictionary: " + Arrays.toString(dictionary.values()));
    }
}