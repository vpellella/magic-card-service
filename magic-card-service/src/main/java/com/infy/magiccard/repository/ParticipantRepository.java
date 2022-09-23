package com.infy.magiccard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.magiccard.entity.card.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer>{

	List<Participant> findByAge(Integer age);
}
