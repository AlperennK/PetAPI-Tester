package com.epampets.domain.builder;

import com.epampets.domain.entity.Pet;
import com.epampets.domain.entity.PetStatus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PetBuilder {
    private int _id = 21;
    private String _name = "Gaspar";
    private Pet.Category _category = new Pet.Category(7, "mamal");
    private List<String> _photoUrls = new ArrayList<String>();
    private PetStatus _status = PetStatus.available;
    private List<Pet.Tags> _tags =  new ArrayList<Pet.Tags>();


    public PetBuilder withId(int value){
        _id = value;
        _photoUrls.add(0, new File(System.getProperty("user.dir") + "/src/test/resources/file/gaspar.JPG").toString());
        _tags.add(new Pet.Tags(3, "tag"));
        return this;
    }

    public PetBuilder withName(String value){
        _name = value;
        return this;
    }

    public PetBuilder withStatus(String value){
        _status = PetStatus.valueOf(value);
        return this;
    }

    public Pet build(){
        return new Pet(){{
            this.id = _id;
            this.name = _name;
            this.category = _category;
            this.photoUrls = _photoUrls;
            this.status = _status;
            this.tags = _tags;
        }};
    }
}
