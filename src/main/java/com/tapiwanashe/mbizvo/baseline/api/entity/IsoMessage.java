package com.tapiwanashe.mbizvo.baseline.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "iso_messages")
public class IsoMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iso_message_seq_gen")
    @SequenceGenerator(
            name = "iso_message_seq_gen",
            sequenceName = "iso_message_seq",
            allocationSize = 1
    )
    private Long id;
    private String messageBody;
    private String messageHeader;
}
