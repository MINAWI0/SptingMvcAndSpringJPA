package com.minaoui.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studenId;
    private String firstName;
    private String lastName;
    @Column(
            name="email_address",
            nullable = false
    )
    private String emailId;
    @Embedded
    private Guardian guardian;
}
