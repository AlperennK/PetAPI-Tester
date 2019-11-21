package com.epampets.domain.entity;

import java.util.List;

public class Pet {
    public int id;
    public String name;
    public Category category;
    public List<String> photoUrls;
    public PetStatus status;
    public List<Tags> tags;


    public static class Category{
        public int id;
        public String name;

        public Category(int id, String name){
            this.id = id;
            this.name = name;
        }
    }

    public static class Tags{
        public int id;
        public String name;

        public Tags(int id, String name){
            this.id = id;
            this.name = name;
        }
    }
}
