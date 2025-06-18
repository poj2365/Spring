package com.bs.spring.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    @NotEmpty(message="아이디는 필수 :(")
    @Size(min=4,message = "아이디는 4글자 이상 입력 :(")
    private String userId;
    @Pattern(regexp = "(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()])[\\da-zA-Z!@#$%^&*()]{8,}",
            message = "특수기호,대문자,숫자포함 8글자로 작성해주세요 :(")
    private String password;
    @Pattern(regexp = "[가-힝a-zA-Z]{2,}",message="이름은 한글,영문자 2글자이상")
    private String userName;
    private String gender;
    @Min(20)
    @Max(100)
    private int age;
    @NotEmpty
    @Email
    private String email;
    private String phone;
    private String address;
    private String[] hobby;
    private Date enrollDate;
}
