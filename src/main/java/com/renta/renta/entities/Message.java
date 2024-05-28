package com.renta.renta.entities;

import com.renta.renta.core.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Message extends BaseEntity<Integer> {

    @Column(name="senderName")
    @NotNull(message = "senderName may not be null")
    private String senderName;
    @Column(name="senderMail")
    @NotNull(message = "senderMail may not be null")
    private String senderMail;
    @Column(name="subject")
    private String subject;
    @Column(name="message")
    @NotNull(message = "message may not be null")
    private String message;
}