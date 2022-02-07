package com.msu.voters_roll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msu.voters_roll.model.Voters;

public interface VotersRepository extends JpaRepository<Voters, Integer>{

}
