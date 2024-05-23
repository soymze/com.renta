package com.renta.renta.entities;

import com.renta.renta.core.BaseEntity;
import jakarta.persistence.*;
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
    private String senderName;
    @Column(name="senderMail")
    private String senderMail;
    @Column(name="subject")
    private String subject;
    @Column(name="message")
    private String message;
}