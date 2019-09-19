package com.meeting.itatiba.demo.controller;

import java.util.List;

import com.meeting.itatiba.demo.service.ServiceMeeting;
import com.meeting.itatiba.demo.domain.vo.MeetingVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void saveMeeting(@RequestBody MeetingVO meetingRequest) {
        log.info("saveMeeting, I=InitMethod");
        serviceMeeting.saveMeeting(meetingRequest);
    }

    @ApiOperation(
            value = "Listar todas as meetings",
            response = MeetingVO.class
    )
    @GetMapping
    public List<MeetingVO> listAll() {
        log.info("listAll, I=InitMethod");
        return serviceMeeting.searchAll();
    }
}



