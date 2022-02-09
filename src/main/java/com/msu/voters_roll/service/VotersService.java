package com.msu.voters_roll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msu.voters_roll.dto.VoterRequest;
import com.msu.voters_roll.exception.VoterNotFoundException;
import com.msu.voters_roll.model.Voter;
import com.msu.voters_roll.repository.VotersRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class VotersService {
	private final VotersRepository votersRepo;
	
	public Voter save(Voter voter) {
		int num = votersRepo.exitsByNationalid(voter.getNationalId());
		
		if(num >= 1) {
			log.warn("Duplicate national id "+voter.getNationalId());
		} else {
			Voter newVoter = votersRepo.save(voter);
			return newVoter;
		}
		return voter;
	}
	
	public List<Voter> getVoters(){
		return votersRepo.findAll();
	}
	
	public Voter getVoterBySurnameAndId(VoterRequest request) {
		return votersRepo.getVoterwithIDandSurname(request.getNationalId(), request.getSurname())
				.orElseThrow(()-> new VoterNotFoundException("Voter with national"+request.getNationalId()+" and surname "+request.getSurname()+" not found"));
	}
	
	
	
	
}
