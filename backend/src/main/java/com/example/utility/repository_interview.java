package com.example.utility;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface repository_interview extends CrudRepository<interview,String>{
    
    List<interview> findByInterviewerMailAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(String interviewerMail, LocalDateTime startTime, LocalDateTime endTime);
    List<interview> findByInterviewerMailAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(String interviewerMail, LocalDateTime startTime, LocalDateTime endTime);
    List<interview> findByInterviewerMailAndStartTimeGreaterThanEqualAndStartTimeLessThan(String interviewerMail, LocalDateTime startTime, LocalDateTime endTime);
    List<interview> findByInterviewerMailAndEndTimeGreaterThanAndEndTimeLessThanEqual(String interviewerMail, LocalDateTime startTime, LocalDateTime endTime);
    List<interview> findByIntervieweeMailAndStartTimeGreaterThanEqualAndStartTimeLessThan(String intervieweeMail, LocalDateTime startTime, LocalDateTime endTime);
    List<interview> findByIntervieweeMailAndEndTimeGreaterThanAndEndTimeLessThanEqual(String intervieweeMail, LocalDateTime startTime, LocalDateTime endTime);
    List<interview> findByIntervieweeMailAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(String interviewerMail, LocalDateTime startTime, LocalDateTime endTime);
    List<interview> findByIntervieweeMailAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(String interviewerMail, LocalDateTime startTime, LocalDateTime endTime);
}




