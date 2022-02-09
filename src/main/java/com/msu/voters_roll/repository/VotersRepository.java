package com.msu.voters_roll.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.msu.voters_roll.model.Voter;

public interface VotersRepository extends JpaRepository<Voter, Integer>{
	
	@Query("SELECT COUNT(v) FROM voter v WHERE v.nationalid =:nationalid")
	public int exitsByNationalid(@Param("nationalid")  String nationalId);

	@Query("SELECT v FROM voter v WHERE v.nationalid =:nationalid AND v.surname =:surname")
	public Optional<Voter> getVoterwithIDandSurname(@Param("nationalid")  String nationalId, @Param("surname")  String surname);
}
