package com.msu.votersroll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msu.votersroll.dto.VoterRequest;
import com.msu.votersroll.exception.VoterNotFoundException;
import com.msu.votersroll.model.Voter;
import com.msu.votersroll.repository.VotersRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class VotersService {
	private final VotersRepository votersRepo;
	
	public Voter save(Voter voter) {
		int num = votersRepo.exitsByNationalid(voter.getNationalId());
		String s = Integer.toString(num);
		log.debug(s);
		if(num >= 1) {
			log.warn("Duplicate national id "+voter.getNationalId());
		} else {
			Voter newVoter = votersRepo.save(voter);
			return newVoter;
		}
		return null;
	}
	
	public List<Voter> getVoters(){
		return votersRepo.findAll();
	}
	
	public Voter getVoterBySurnameAndId(VoterRequest request) {
		return votersRepo.getVoterwithIDandSurname(request.getNationalId(), request.getSurname())
				.orElseThrow(()-> new VoterNotFoundException("Voter with national"+request.getNationalId()+" and surname "+request.getSurname()+" not found"));
	}
		
}
