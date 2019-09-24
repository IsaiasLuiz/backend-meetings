package com.meeting.itatiba.demo.controller;

import java.util.List;

import com.meeting.itatiba.demo.domain.exception.DateInvalidException;
import com.meeting.itatiba.demo.domain.vo.MeetingVO;
import com.meeting.itatiba.demo.service.ServiceMeeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(
        tags = "meetings",
        value = "/meetings"
)
@RestController
@RequestMapping("/meetings")
public class MeetingRequestController {

    @Autowired
    private ServiceMeeting serviceMeeting;

    @ApiOperation(
            value = "Salvar meeting"
    )
    @PostMapping
    public ResponseEntity saveMeeting(@RequestBody MeetingVO meetingRequest) {
        log.info("saveMeeting, I=InitMethod");

        try {
            serviceMeeting.saveMeeting(meetingRequest);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (DateInvalidException e) {
            log.info("saveMeeting, E=erro ao salvar meeting");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(
            value = "Listar todas as meetings",
            response = MeetingVO.class
    )
    @GetMapping
    public ResponseEntity<List<MeetingVO>> listAll() {
        log.info("listAll, I=InitMethod");
        return ResponseEntity.status(HttpStatus.OK).body(serviceMeeting.searchAll());
    }

    @ApiOperation(
            value = "Apagar todas as meetings"
    )
    @DeleteMapping
    public ResponseEntity deleteAll() {
        log.info("M=deleteAll, I=InitMethod");
        serviceMeeting.deleteAll();
        log.info("M=deleteAll, I=endMethod");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}



