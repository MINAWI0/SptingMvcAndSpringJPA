package com.minaoui.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {
    private Long studenId;
    private String firstName;
    private String lastName;
    private String emailId;
}
