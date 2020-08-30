package com.example.utility;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface repository_person extends CrudRepository<person,String>{

    List<person> findByMailId(String MailId);
}


