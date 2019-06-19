package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map <String, List<String>> myBookofPhones;




    public PhoneBook(Map<String, List<String>> map) {
        this.myBookofPhones = map;
    }

    public PhoneBook() {
        myBookofPhones = new LinkedHashMap<>();

    }

    public void add(String name, String phoneNumber) {
        List<String> result = lookup(name);

        if(result == null){
            result = new ArrayList<>();
        }

        result.add(phoneNumber);
        myBookofPhones.put(name, result);

    }

    public void addAll(String name, String... phoneNumbers) {
        for(String numbers: phoneNumbers){
            List<String> result = lookup(name);

            if(result == null){
                result = new ArrayList<>();
            }

            result.add(numbers);
            myBookofPhones.put(name, result);

        }


    }

    public void remove(String name) {
        myBookofPhones.remove(name);


    }

    public Boolean hasEntry(String name) {
        List<String> number = new ArrayList<>();
        number.add(name);


        if(myBookofPhones.containsKey(name) || myBookofPhones.containsValue(number)){
            return true;
        }


        return false;
    }

    public List<String> lookup(String name) {

        return myBookofPhones.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(String name: myBookofPhones.keySet()){
            List<String> numberFound = myBookofPhones.get(name);
            if(numberFound.contains(phoneNumber)){
                return name;
            }
        }

        return null;
    }

    public List<String> getAllContactNames() {
        List<String> contacts = new ArrayList<>();
        for(String name: myBookofPhones.keySet()){

            contacts.add(name);
        }



        return contacts;
    }

    public Map<String, List<String>> getMap() {
        return myBookofPhones;
    }
}
