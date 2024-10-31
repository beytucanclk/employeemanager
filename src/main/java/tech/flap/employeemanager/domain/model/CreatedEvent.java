package tech.flap.employeemanager.domain.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreatedEvent implements Serializable {
    private String mail;
    private String name;
    private String surname;
}
