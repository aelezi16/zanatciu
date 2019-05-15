package com.zanatciu.backend.domain.application.service;

import com.zanatciu.backend.domain.application.model.Application;
import com.zanatciu.backend.domain.application.repo.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ApplicationFilter {

    private ApplicationRepo applicationRepo;

    @Autowired
    public ApplicationFilter(
            ApplicationRepo applicationRepo
    ){
        this.applicationRepo = applicationRepo;
    }

    @Scheduled(fixedDelay = 1000*60*30)
    private void filterExpiredApplications(){
        List<Application> all = applicationRepo.findAll();

        Date now = new Date();
        all.forEach(a->{
            if(now.getTime() - a.getTimestamp().getTime() >= 1000*60*60){
                a.setStatus("EXPIRED");
                applicationRepo.save(a);
            }
        });
    }

}
