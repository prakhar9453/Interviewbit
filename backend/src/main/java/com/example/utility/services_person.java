package com.example.utility;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class services_person {

    @Autowired
    private repository_person repo;

    public List<person> getAllPerson() {

        List<person> temp = new ArrayList<>();
        repo.findAll().forEach(temp::add);
        return temp;

    }

    public void addPerson(person t){
        
        repo.save(t);
        return;

    }

}