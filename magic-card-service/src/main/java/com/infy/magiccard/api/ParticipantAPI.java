package com.infy.magiccard.api;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.infy.magiccard.dto.ParticipantDto;
import com.infy.magiccard.exception.CardDrawingException;
import com.infy.magiccard.service.ParticipantService;

@RestController
@Validated
@RequestMapping("/api")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:ValidationMessages.properties")
@CrossOrigin
public class ParticipantAPI {

	private final ParticipantService participantService;
	private final Environment environment;

	@Value("${pariticipantNameIsMandatory}")
    private String pariticipantNameIsMandatory;
	@Value("${pleaseProvideValidName}")
    private String pleaseProvideValidName;
	@Value("${pariticipantAgeIsMandatory}")
    private String pariticipantAgeIsMandatory;
	@Value("${pleaseProvideEmailAddress}")
    private String pleaseProvideEmailAddress;
	@Value("${pleaseProvideContactNumber}")
    private String pleaseProvideContactNumber;
	@Value("${pleaseProvideValidEmailAddress}")
    private String pleaseProvideValidEmailAddress;
    @Value("${pleaseProvideValidCardDetails}")
    private String pleaseProvideValidCardDetails;
	
	@Autowired
	public ParticipantAPI(ParticipantService participantService, Environment environment) {
		this.participantService = participantService;
		this.environment = environment;
	}
	
	@PostMapping(path = "/participants", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)			
	public ResponseEntity<String> addParticipant(@Valid @RequestBody ParticipantDto participantDto) throws CardDrawingException {
		
		System.out.println(participantDto);
		if(participantDto.getName() == null)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pariticipantNameIsMandatory);

		if(!participantDto.getName().matches("[A-z][a-z\\s]+"))
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pleaseProvideValidName);

		if(participantDto.getAge() == null)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pariticipantAgeIsMandatory);

		if(participantDto.getContact() == null)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pleaseProvideContactNumber);

		if(participantDto.getMailId() == null)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pleaseProvideEmailAddress);

		if(!participantDto.getMailId().matches("[A-Za-z0-9._%+-]+[A-Za-z0-9._%+-]+@[gmail|infy|yahoo]+.com"))
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pleaseProvideValidEmailAddress);

		if(participantDto.getCard() == null)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pleaseProvideValidCardDetails);

		Integer id = participantService.addParticipant(participantDto);
		String message = environment.getProperty("API.ADDED_PARTICIPANT_ADDED_SUCCESSFULLY");
		message = message.concat("" + id);

		return new ResponseEntity<String>(HttpStatus.CREATED).ok(message); 
	}

	@PostMapping(path = "/participants/register", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerParticipant(@Valid @RequestBody ParticipantDto participantDto) throws CardDrawingException {

		System.out.println(participantDto);
		if(participantDto.getName() == null)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pariticipantNameIsMandatory);

		if(!participantDto.getName().matches("[A-z][a-z\\s]+"))
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pleaseProvideValidName);

		if(participantDto.getAge() == null)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pariticipantAgeIsMandatory);

		if(participantDto.getContact() == null)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pleaseProvideContactNumber);

		if(participantDto.getMailId() == null)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pleaseProvideEmailAddress);

		if(!participantDto.getMailId().matches("[A-Za-z0-9._%+-]+[A-Za-z0-9._%+-]+@[gmail|infy|yahoo]+.com"))
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pleaseProvideValidEmailAddress);

		if(participantDto.getCard() == null)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).ok(pleaseProvideValidCardDetails);

		Integer id = participantService.registerParticipant(participantDto);
		String message = environment.getProperty("API.ADDED_PARTICIPANT_ADDED_SUCCESSFULLY");
		message = message.concat("" + id);

		return new ResponseEntity<String>(HttpStatus.CREATED).ok(message);
	}

	@GetMapping(path = "/participants/{age}")
	public ResponseEntity<List<ParticipantDto>> getParticipantsByAge(@Valid @PathVariable("age") Integer age) throws CardDrawingException {
		List<ParticipantDto> participantsList = participantService.getListOfParticipants(age);
		return new ResponseEntity<String>(HttpStatus.OK).ok(participantsList);
		
	}
	
	@GetMapping(path = "/participants")
	public ResponseEntity<List<ParticipantDto>> getAllParticipants() {
		List<ParticipantDto> participantsList = participantService.getAllParticipants();
		return new ResponseEntity<String>(HttpStatus.OK).ok(participantsList);
		
	}
}
