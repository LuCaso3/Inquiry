package com.mysite.sbb.inquiry;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(length = 200)
	private String subject;

	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
	
	@Column
	private Boolean open; //체크박스 테스트
	
	@Column
	private String budget; // 예산 범위
	
	@Column
	private String Date;	// 프로젝트 일정
	
	private List<String> regions; // 희망 서비스
}

