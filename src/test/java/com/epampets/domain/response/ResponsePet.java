package com.epampets.domain.response;

import com.epampets.domain.entity.PetStatus;

import java.util.List;

public class ResponsePet {
    public int id;
    public String name;
    public Category category;
    public List<String> photoUrls;
    public PetStatus status;
    public List<Tags> tags;

    public static class Category {
        public int id;
        public String name;
    }

    public static class Tags{
        public int id;
        public String name;
    }
}
