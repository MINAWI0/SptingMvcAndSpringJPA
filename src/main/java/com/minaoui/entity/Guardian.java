package com.minaoui.entity;



import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardianName")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guradianMobile")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guradianEmail")
        )
})
public class Guardian {
    private String name;
    private String mobile;
    private String email;
}
