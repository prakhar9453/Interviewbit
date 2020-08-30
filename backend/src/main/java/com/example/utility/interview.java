package com.example.utility;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String interviewerMail;
    private String intervieweeMail;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public interview()
    {

    }

    public interview(String mail1, String mail2, LocalDateTime start, LocalDateTime end)
    {
          this.interviewerMail=mail1;
          this.intervieweeMail=mail2;
          this.startTime=start;
          this.endTime=end;
    }

    public void setInterviewerMail(String mail1){

        this.interviewerMail=mail1;

    }
    public String getInterviewerMail(){

       return this.interviewerMail;

    }
    public void setIntervieweeMail(String mail2){

        this.intervieweeMail=mail2;

    }
    public String getIntervieweeMail(){

       return this.intervieweeMail;

    }

    public void setStartDate(LocalDateTime start){

        this.startTime=start;

    }
    public LocalDateTime getStartTime(){

       return this.startTime;

    }
    public void setEndTime(LocalDateTime end){

        this.endTime=end;
    }
    public LocalDateTime getEndTime(){

        return this.endTime;
 
     }
    public void setId(Long t)
    {
        this.id=t;
        return;
    }
    public Long getId(){

       return this.id;

    }


}