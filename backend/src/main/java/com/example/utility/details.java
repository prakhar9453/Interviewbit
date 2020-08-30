package com.example.utility;

import java.time.LocalDateTime;

public class details {

    private Long id;
    private String interviewer;
    private String interviewee;
    private String interviewerMail;
    private String intervieweeMail;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public details()
    {

    }

    public details(Long id,String person1, String mail1, String person2, String mail2, LocalDateTime start, LocalDateTime end)
    {
          this.id=id;
          this.interviewer=person1;
          this.interviewee=person2;
          this.interviewerMail=mail1;
          this.intervieweeMail=mail2;
          this.startTime=start;
          this.endTime=end;
    }


    public void setInterviewer(String person1){

        this.interviewer=person1;

    }
    public String getInterviewer(){

       return this.interviewer;

    }
    public void setInterviewee(String person2){

        this.interviewee=person2;

    }
    public String getInterviewee(){

       return this.interviewee;

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