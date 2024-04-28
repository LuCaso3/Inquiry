package com.mysite.sbb.inquiry;

import java.util.List;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InquiryForm {
    @NotEmpty(message="제목은 필수항목입니다.")
    @Size(max=200)
    private String subject;

    @NotEmpty(message="내용은 필수항목입니다.")
    private String content;
    
    @AssertTrue(message="체크는 필수항목입니다.")
    private Boolean open;
    
    @NotEmpty(message="멀티체크는 필수항목입니다.")
	private List<String> regions;
    
    @NotEmpty(message="선택은 필수항목입니다.")
    private String budget;
    
    @NotEmpty(message="일정은 필수항목입니다.")
    private String Date;	
}