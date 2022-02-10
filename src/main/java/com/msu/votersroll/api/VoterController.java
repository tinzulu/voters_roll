package com.msu.votersroll.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msu.votersroll.dto.VoterRequest;
import com.msu.votersroll.model.Voter;
import com.msu.votersroll.service.VotersService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/voter")
@AllArgsConstructor
public class VoterController {
	private final VotersService voterService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Voter voter){
		Voter newVoter = voterService.save(voter);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(newVoter);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<Voter> voters = voterService.getVoters();
		return ResponseEntity.status(HttpStatus.OK)
				.body(voters);
	}
	
	@GetMapping("/check")
	public ResponseEntity<?> getByIdAndSurname(@RequestBody VoterRequest request){
		Voter voter = voterService.getVoterBySurnameAndId(request);
		return ResponseEntity.status(HttpStatus.OK)
				.body(voter);
	}
	
	
}
