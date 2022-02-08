package com.msu.voters_roll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.msu.voters_roll.model.Voter;

public interface VotersRepository extends JpaRepository<Voter, Integer>{
	
	@Query("SELECT COUNT(v) FROM voters v WHERE i.nationalid =:nationalid")
	public int exitsByNationalid(@Param("nationalid")  String nationalId);
}
