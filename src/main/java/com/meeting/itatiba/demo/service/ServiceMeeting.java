package com.meeting.itatiba.demo.service;

import java.util.List;

import com.meeting.itatiba.demo.domain.vo.MeetingVO;

public interface ServiceMeeting {

    void saveMeeting(MeetingVO meentingRequest);

    List<MeetingVO> searchAll();
}
