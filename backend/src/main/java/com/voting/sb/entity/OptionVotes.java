package com.voting.sb.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class OptionVotes {
private String options;
private Long voteCount = 0l;
public String getOptions() {
	return options;
}
public void setOptions(String options) {
	this.options = options;
}
public Long getVoteCount() {
	return voteCount;
}
public void setVoteCount(Long voteCount) {
	this.voteCount = voteCount;
}
public OptionVotes(String options, Long voteCount) {
	super();
	this.options = options;
	this.voteCount = voteCount;
}
public OptionVotes() {
	super();
	// TODO Auto-generated constructor stub
}

}
