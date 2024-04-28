package com.mysite.sbb.inquiry;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import lombok.RequiredArgsConstructor;

@RequestMapping("/inquiry")
@RequiredArgsConstructor
@Controller
public class InquiryController {

	private final InquiryService inquiryService;
	
    @GetMapping("/list")
    public String list(Model model) {
    	List<Inquiry> inquiryList = this.inquiryService.getList();
        model.addAttribute("inquiryList", inquiryList);
        return "inquiry_list";
    }
    
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
    	Inquiry inquiry = this.inquiryService.getInquiry(id);
        model.addAttribute("inquiry", inquiry);
        
        return "inquiry_detail";
    }
    
    @GetMapping("/create")
    public String inquiryCreate(InquiryForm inquiryForm) {
        return "inquiry_form";
    }
    
    @PostMapping("/create")
    public String inquiryCreate(@Valid InquiryForm inquiryForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "inquiry_form";
        }
        this.inquiryService.create(inquiryForm.getSubject(), inquiryForm.getContent(), inquiryForm.getOpen(), inquiryForm.getRegions(), inquiryForm.getDate(), inquiryForm.getBudget());
        return "redirect:/inquiry/list";
    }
    
   
}