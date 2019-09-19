package com.meeting.itatiba.demo.domain.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class MeetingVO {

    private String title;

    private LocalDate date;

    private String description;

    private String author;
}
