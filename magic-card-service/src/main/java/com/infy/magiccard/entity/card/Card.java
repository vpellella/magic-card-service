package com.infy.magiccard.entity.card;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cardId;
	private String cardNumber;
	private Integer price;
	
	
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cardId, cardNumber, price);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Card)) {
			return false;
		}
		Card other = (Card) obj;
		return Objects.equals(cardId, other.cardId) && Objects.equals(cardNumber, other.cardNumber)
				&& Objects.equals(price, other.price);
	}
	
}
