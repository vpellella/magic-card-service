package com.infy.magiccard.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ParticipantDto {

	private Integer participantId;
	private String name;
	private Integer age;
	private String mailId;
	private Long contact;
	private CardDto cardDto;
	
	public Integer getParticipantId() {
		return participantId;
	}
	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public CardDto getCardDto() {
		return cardDto;
	}
	public void setCardDto(CardDto cardDto) {
		this.cardDto = cardDto;
	}
	@Override
	public String toString() {
		return "ParticipantDto [participantId=" + participantId + ", name=" + name + ", age=" + age + ", mailId="
				+ mailId + ", contact=" + contact + ", cardDto=" + cardDto + "]";
	}
	
	
}
