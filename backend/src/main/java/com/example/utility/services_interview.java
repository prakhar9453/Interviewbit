package com.example.utility;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class services_interview {

    @Autowired
    private repository_interview repo;
    @Autowired
    private repository_person repo1;

    public List<details> getAllInterview() {

        List<interview> temp = new ArrayList<>();
        repo.findAll().forEach(temp::add);

        List<details> ans=new ArrayList<>();

        for(int i=0;i<temp.size();i++)
        {
            List<person> temp1 = new ArrayList<>();
            repo1.findByMailId(temp.get(i).getInterviewerMail()).forEach(temp1::add);

            List<person> temp2 = new ArrayList<>();
            repo1.findByMailId(temp.get(i).getIntervieweeMail()).forEach(temp2::add);

            details x=new details(temp.get(i).getId(),temp1.get(0).getName(),temp.get(i).getInterviewerMail(),temp2.get(0).getName(),temp.get(i).getIntervieweeMail(),temp.get(i).getStartTime(),temp.get(i).getEndTime());

            ans.add(x);

        }

        return ans;
        
    }

    public int addInterview(interview t){

        List<interview> temp1 = new ArrayList<>();

        repo.findByInterviewerMailAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
        
        repo.findByInterviewerMailAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;

        repo.findByInterviewerMailAndStartTimeGreaterThanEqualAndStartTimeLessThan(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
        
        repo.findByInterviewerMailAndEndTimeGreaterThanAndEndTimeLessThanEqual(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
        
        repo.findByIntervieweeMailAndStartTimeGreaterThanEqualAndStartTimeLessThan(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
            
        repo.findByIntervieweeMailAndEndTimeGreaterThanAndEndTimeLessThanEqual(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
        
        repo.findByIntervieweeMailAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
        
        repo.findByIntervieweeMailAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
        
        repo.findByInterviewerMailAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
        
        repo.findByInterviewerMailAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;

        repo.findByInterviewerMailAndStartTimeGreaterThanEqualAndStartTimeLessThan(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
        
        repo.findByInterviewerMailAndEndTimeGreaterThanAndEndTimeLessThanEqual(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
        
        repo.findByIntervieweeMailAndStartTimeGreaterThanEqualAndStartTimeLessThan(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
            
        repo.findByIntervieweeMailAndEndTimeGreaterThanAndEndTimeLessThanEqual(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
        
        repo.findByIntervieweeMailAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
        
        repo.findByIntervieweeMailAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>0)
            return-1;
        

        repo.save(t);
        return 1;

    }

    public int updateInterview(interview t, Long id)
    {
        t.setId(id);

        List<interview> temp1 = new ArrayList<>();

        repo.findByInterviewerMailAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();
        
        repo.findByInterviewerMailAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();

        repo.findByInterviewerMailAndStartTimeGreaterThanEqualAndStartTimeLessThan(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();
        
        repo.findByInterviewerMailAndEndTimeGreaterThanAndEndTimeLessThanEqual(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();
        
        repo.findByIntervieweeMailAndStartTimeGreaterThanEqualAndStartTimeLessThan(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();
            
        repo.findByIntervieweeMailAndEndTimeGreaterThanAndEndTimeLessThanEqual(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();

        repo.findByIntervieweeMailAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();
        
        repo.findByIntervieweeMailAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(t.getInterviewerMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();

        repo.findByInterviewerMailAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();
        
        repo.findByInterviewerMailAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();

        repo.findByInterviewerMailAndStartTimeGreaterThanEqualAndStartTimeLessThan(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();
        
        repo.findByInterviewerMailAndEndTimeGreaterThanAndEndTimeLessThanEqual(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();
        
        repo.findByIntervieweeMailAndStartTimeGreaterThanEqualAndStartTimeLessThan(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();
            
        repo.findByIntervieweeMailAndEndTimeGreaterThanAndEndTimeLessThanEqual(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();

        repo.findByIntervieweeMailAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();
        
        repo.findByIntervieweeMailAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(t.getIntervieweeMail(),t.getStartTime(),t.getEndTime()).forEach(temp1::add);
        if(temp1.size()>1)
            return-1;
        else if(temp1.size()==1 && temp1.get(0).getId()!=t.getId())
            return -1;

        temp1.clear();

        repo.save(t);
        return 1;
    }

}