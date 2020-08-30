package com.example.utility;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
public class controller_details {

    @Autowired
    private services_interview ser1;
    @Autowired
    private services_person ser2;

    @RequestMapping("/interview")
    public List<details> getAllInterview() {

        return ser1.getAllInterview();

    }
    @RequestMapping("/person")
    public List<person> getAllPerson() {

        return ser2.getAllPerson();

    }

    @RequestMapping(method=RequestMethod.POST,value="/")
    public int addInterview(@RequestBody details t)
    {
        interview i = new interview(t.getInterviewerMail(),t.getIntervieweeMail(),t.getStartTime(),t.getEndTime());
        int x = ser1.addInterview(i);

        if(x==-1)
        {
            return -1;
        }

        person p1 = new person(t.getIntervieweeMail(),t.getInterviewee());
        person p2 = new person(t.getInterviewerMail(),t.getInterviewer());
        ser2.addPerson(p1);
        ser2.addPerson(p2);

        return 1;
    }
    @RequestMapping(method=RequestMethod.PUT,value="/{id}")
    public int updateInterview(@RequestBody details t, @PathVariable Long id)
    {
        interview i = new interview(t.getInterviewerMail(),t.getIntervieweeMail(),t.getStartTime(),t.getEndTime());
        int x=ser1.updateInterview(i,id);

        if(x==-1)
        {
            return -1;
        }

        person p1 = new person(t.getIntervieweeMail(),t.getInterviewee());
        person p2 = new person(t.getInterviewerMail(),t.getInterviewer());
        ser2.addPerson(p1);
        ser2.addPerson(p2);

        return 1;


    }
}