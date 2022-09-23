package com.infy.magiccard.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonAutoDetect
public class ParticipantDto {

	private Integer participantId;
	private String name;
	private Integer age;
	private String mailId;
	private Long contact;
	@JsonProperty("card")
	private CardDto card;
	
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
	public CardDto getCard() {
		return card;
	}
	public void setCard(CardDto card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "ParticipantDto [participantId=" + participantId + ", name=" + name + ", age=" + age + ", mailId="
				+ mailId + ", contact=" + contact + ", cardDto=" + card + "]";
	}
	
	
}
