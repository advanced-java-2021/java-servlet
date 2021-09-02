package com.java.jaksonUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class JacksonUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object o){
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toObject(String json, Class<T> t){
        try {
            return mapper.readValue(json,t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static <T> T toObject(InputStream json, Class<T> t){
        try {
            return mapper.readValue(json,t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.setName("saroj");
        s.setRoll(UUID.randomUUID().toString());
        s.setGender("male");
        System.out.println(s.hashCode());
        System.out.println(s);

        // serialization : stream of bytes to json data
        String jsonData = toJson(s);
        System.out.println(jsonData);
        // deserialization :  json data to stream of bytes
        s = toObject(jsonData,Student.class);
        System.out.println(s.hashCode());
        System.out.println(s);
        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream("data.json");

        s = toObject(is, Student.class);
        System.out.println(s.hashCode());
        System.out.println(s);
    }
}
