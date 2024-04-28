package com.mysite.sbb.inquiry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    public List<Inquiry> getList() {
        return this.inquiryRepository.findAll();
    }  
    
    public Inquiry getInquiry(Long id) {  
        Optional<Inquiry> inquiry = this.inquiryRepository.findById(id);
        if (inquiry.isPresent()) {
            return inquiry.get();
        } else {
            throw new DataNotFoundException("inquiry not found");
        }
    }
    
    public void create(String subject, String content, Boolean open, List<String> regions, String Date, String budget) {
        Inquiry q = new Inquiry();
        q.setSubject(subject);
        q.setContent(content);
        q.setOpen(open);
        q.setRegions(regions);
        q.setDate(Date);
        q.setBudget(budget);
        q.setCreateDate(LocalDateTime.now());
        this.inquiryRepository.save(q);
    }
}