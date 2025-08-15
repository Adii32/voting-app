package com.voting.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voting.sb.entity.Poll;

@Repository
public interface PollRepo extends JpaRepository<Poll,Long> {

}
