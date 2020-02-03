package org.micronaut.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Setter
public class User {

    private String name;
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    // Empty constructor for JSON/JPA
    public User() {
        name = null;
    }

}
