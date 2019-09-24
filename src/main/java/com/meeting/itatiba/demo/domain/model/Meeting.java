package com.meeting.itatiba.demo.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "MEETINGS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ID")
    private long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AUTHOR")
    private String author;
}
