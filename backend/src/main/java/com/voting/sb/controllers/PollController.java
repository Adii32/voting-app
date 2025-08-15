package com.voting.sb.controllers;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voting.sb.entity.Poll;
import com.voting.sb.repository.PollRepo;
import com.voting.sb.request.Vote;
import com.voting.sb.service.PollService;

@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = "http://localhost:4200") 
public class PollController {
private final PollService pollService;
public PollController(PollService pollService) {
	this.pollService = pollService;
}

@PostMapping
public Poll createPoll(@RequestBody Poll poll) {
	   System.out.println("Received: " + poll);
	return pollService.createPoll(poll);
}
@GetMapping("/{id}")
public ResponseEntity<Poll> getPoll(@PathVariable Long id) {
    return pollService.getPoll(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@GetMapping
public ResponseEntity<List<Poll>> getAllPolls() {
	List<Poll> polls = pollService.getAllPolls();
	return ResponseEntity.ok(polls);
}
@PostMapping("/vote")


public ResponseEntity<Poll> vote(@RequestBody Vote vote) {
    Poll updatedPoll = pollService.vote(vote.getPollId(), vote.getOptionIndex());
    return ResponseEntity.ok(updatedPoll);
}
}


