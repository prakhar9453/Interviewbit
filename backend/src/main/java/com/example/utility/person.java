package com.example.utility;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class person {
    
    @Id
    private String mailId;
    private String  name;

    public person()
    {

    }
    public person(String mail, String name)
    {
        this.mailId=mail;
        this.name=name;
    }

    public void setMailId(String mail)
    {
        this.mailId=mail;
    }
    public String getMailId()
    {
        return this.mailId;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }

}