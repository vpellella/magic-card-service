package com.infy.magiccard.service;

import java.util.List;

import com.infy.magiccard.dto.ParticipantDto;
import com.infy.magiccard.exception.CardDrawingException;

public interface ParticipantService {

	Integer addParticipant(ParticipantDto participantDto) throws CardDrawingException;
	Integer registerParticipant(ParticipantDto participantDto) throws CardDrawingException;
	List<ParticipantDto> getListOfParticipants(Integer age) throws CardDrawingException;
	List<ParticipantDto> getAllParticipants();
}
