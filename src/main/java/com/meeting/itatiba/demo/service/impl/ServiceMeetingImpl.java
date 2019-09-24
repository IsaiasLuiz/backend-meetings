package com.meeting.itatiba.demo.service.impl;

import com.meeting.itatiba.demo.domain.exception.DateInvalidException;
import com.meeting.itatiba.demo.domain.model.Meeting;
import com.meeting.itatiba.demo.domain.vo.MeetingVO;
import com.meeting.itatiba.demo.service.ServiceMeeting;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.meeting.itatiba.demo.repository.MeetingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceMeetingImpl implements ServiceMeeting {

    @Autowired
    private MeetingRepository meetingRepository;

    @Override
    public void saveMeeting(final MeetingVO meentingRequest) throws Exception {
        log.info("M=saveMeeting, I=InitMethod");
        try{
            if(meentingRequest.getDate().isBefore(LocalDate.now())){
                log.info("M=saveMeeting, I=Meeting com data invalida");
                throw new DateInvalidException("Data invalida");
            }
            Meeting meeting = Meeting.builder()
                    .author(meentingRequest.getAuthor())
                    .date(meentingRequest.getDate())
                    .description(meentingRequest.getDescription())
                    .title(meentingRequest.getTitle())
                    .build();
            log.info("M=saveMeeting, I=Meeting={} preparada pra salvar", meeting);
            meetingRepository.save(meeting);
        }catch (Exception e){
            log.info("M=saveMeeting, E=Ocoreu um erro ao salvar a meeting={}", meentingRequest);
            throw e;
        }

    }

    @Override
    public List searchAll() {
        log.info("M=searchAll, I=InitMethod");
        List<Meeting> responseList;
        responseList = meetingRepository.findAll();

        log.info("M=searchAll, I=Iniciando iteração com a lista de meetings");
        return responseList.stream().map(
                meeting ->
                        MeetingVO.builder()
                                .author(meeting.getAuthor())
                                .date(meeting.getDate())
                                .description(meeting.getDescription())
                                .title(meeting.getTitle()).build()
        ).collect(Collectors.toList());

    }

    @Override
    public void deleteAll() {
        log.info("M=deleteAll, I=InitMethod");
        meetingRepository.deleteAll();
        log.info("M=deleteAll, I=EndMethod");
    }
}
