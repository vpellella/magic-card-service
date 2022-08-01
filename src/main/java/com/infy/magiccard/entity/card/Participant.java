package com.infy.magiccard.entity.card;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Participant")
public class Participant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer participantId;
	private String name;
	private Integer age;
	private String mailId;
	private Long contact;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
	private Card card;

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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, card, contact, mailId, name, participantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Participant)) {
			return false;
		}
		Participant other = (Participant) obj;
		return Objects.equals(age, other.age) && Objects.equals(card, other.card)
				&& Objects.equals(contact, other.contact) && Objects.equals(mailId, other.mailId)
				&& Objects.equals(name, other.name) && Objects.equals(participantId, other.participantId);
	}

}
