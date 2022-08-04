package com.alex.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        try {
            // create object mapper
            ObjectMapper objectMapper = new ObjectMapper();

            // read JSON file and map/convert to Java POJO: data/sample-lite.json
            Student student = objectMapper.readValue(new File("jackson-databinding-json-demo/data/sample-full.json"), Student.class);

            // print first name and last name
            System.out.println("First name = " + student.getFirstName());
            System.out.println("Last name = " + student.getLastName());

            // print out address: street and city
            Address address = student.getAddress();
            System.out.println("Street= " + address.getStreet());
            System.out.println("City= " + address.getCity());

            // print out languages
            for(String language : student.getLanguages()) {
                System.out.println(language);
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
