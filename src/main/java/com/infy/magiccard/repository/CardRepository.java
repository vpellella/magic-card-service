package com.infy.magiccard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.magiccard.entity.card.Card;

public interface CardRepository extends JpaRepository<Card, Integer>{

}
