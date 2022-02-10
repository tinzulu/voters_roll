package com.msu.votersroll.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.msu.votersroll.model.Voter;

public interface VotersRepository extends JpaRepository<Voter, Integer>{
	
	@Query("SELECT COUNT(v) FROM Voter v WHERE v.nationalId =:nationalId")
	public int exitsByNationalid(@Param("nationalId")  String nationalId);

	@Query("SELECT v FROM Voter v WHERE v.nationalId =:nationalId AND v.surname =:surname")
	public Optional<Voter> getVoterwithIDandSurname(@Param("nationalId")  String nationalId, @Param("surname")  String surname);
}
