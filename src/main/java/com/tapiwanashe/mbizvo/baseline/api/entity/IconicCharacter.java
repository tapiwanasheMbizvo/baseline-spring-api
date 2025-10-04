package com.tapiwanashe.mbizvo.baseline.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "characters")
public class IconicCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "characters_seq_gen")
    @SequenceGenerator(
            name = "characters_seq_gen",
            sequenceName = "characters_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;
}
