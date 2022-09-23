package com.infy.magiccard.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.infy.magiccard.dto.CardDto;
import com.infy.magiccard.dto.ParticipantDto;
import com.infy.magiccard.entity.card.Card;
import com.infy.magiccard.entity.card.Participant;
import com.infy.magiccard.exception.CardDrawingException;
import com.infy.magiccard.repository.CardRepository;
import com.infy.magiccard.repository.ParticipantRepository;

@Service("participantService")
public class ParticipantServiceImpl implements ParticipantService {

	private final CardRepository cardRepository;
	private final ParticipantRepository participantRepository;

	@Value("{ParticipantValidator.Invalid_Age}")
	private String invalidAge;
	@Value("{ParticipantService.CARD_ALREADY_SOLD}")
	private String cardAlreadySold;
	@Value("{ParticipantService.PARTICIPANTS_UNAVIALABLE}")
	private String participantsUnavilable;

	@Autowired
	public ParticipantServiceImpl(CardRepository cardRepository, ParticipantRepository participantRepository) {
		this.cardRepository = cardRepository;
		this.participantRepository = participantRepository;
	}

	public Integer addParticipant(ParticipantDto participantDto) throws CardDrawingException {
		if (participantDto.getAge() < 18)
			throw new CardDrawingException(invalidAge);

		Optional<Card> cardRec = cardRepository.findById(participantDto.getCard().getCardId());

		if (cardRec.isPresent())
			throw new CardDrawingException(cardAlreadySold);

		Card card = new Card();
		card.setCardId(participantDto.getCard().getCardId());
		card.setCardNumber(participantDto.getCard().getCardName());
		card.setPrice(participantDto.getCard().getPrice());
		Participant participant = new Participant();
		participant.setName(participantDto.getName());
		participant.setAge(participantDto.getAge());
		participant.setContact(participantDto.getContact());
		participant.setMailId(participantDto.getMailId());
		participant.setCard(card);

		participant = participantRepository.save(participant);

		return participant.getParticipantId();

	}


	public Integer registerParticipant(ParticipantDto participantDto) throws CardDrawingException {
		if (participantDto.getAge() < 18)
			throw new CardDrawingException(invalidAge);


		Card card = new Card();

		card.setCardNumber(participantDto.getCard().getCardName());
		card.setPrice(participantDto.getCard().getPrice());
		cardRepository.save(card);

		Participant participant = new Participant();
		participant.setName(participantDto.getName());
		participant.setAge(participantDto.getAge());
		participant.setContact(participantDto.getContact());
		participant.setMailId(participantDto.getMailId());
		participant.setCard(card);

		participant = participantRepository.save(participant);

		return participant.getParticipantId();

	}

	public List<ParticipantDto> getListOfParticipants(Integer age) throws CardDrawingException {
		List<Participant> participantsList = participantRepository.findByAge(age);
		if (participantsList == null || participantsList.size() == 0)
			throw new CardDrawingException(participantsUnavilable);

		return participantsList.stream().map(participant -> {
			CardDto cardDto = new CardDto();
			cardDto.setCardId(participant.getCard().getCardId());
			cardDto.setCardName(participant.getCard().getCardNumber());
			cardDto.setPrice(participant.getCard().getPrice());

			ParticipantDto participantDto = new ParticipantDto();
			participantDto.setParticipantId(participant.getParticipantId());
			participantDto.setName(participant.getName());
			participantDto.setAge(participant.getAge());
			participantDto.setContact(participant.getContact());
			participantDto.setMailId(participant.getMailId());
			participantDto.setCard(cardDto);
			return participantDto;
		}).collect(Collectors.toList());

	}
	
	@Override
	public List<ParticipantDto> getAllParticipants() {
		List<Participant> participantsList = participantRepository.findAll();


		return participantsList.stream().map(participant -> {
			CardDto cardDto = new CardDto();
			cardDto.setCardId(participant.getCard().getCardId());
			cardDto.setCardName(participant.getCard().getCardNumber());
			cardDto.setPrice(participant.getCard().getPrice());
			
			ParticipantDto participantDto = new ParticipantDto();
			participantDto.setParticipantId(participant.getParticipantId());
			participantDto.setName(participant.getName());
			participantDto.setAge(participant.getAge());
			participantDto.setContact(participant.getContact());
			participantDto.setMailId(participant.getMailId());
			participantDto.setCard(cardDto);
			
			return participantDto;
		}).collect(Collectors.toList());

	}

}
