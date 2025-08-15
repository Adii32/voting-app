package com.voting.sb.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
public class Poll {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String question;
@ElementCollection
@CollectionTable(name = "poll_options", joinColumns = @JoinColumn(name = "poll_id"))
@Column(name = "options")
private List<OptionVotes> options = new ArrayList<>();

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}

public List<OptionVotes> getOptions() {
	return options;
}
public void setOptions(List<OptionVotes> options) {
	this.options = options;
}
public Poll() {
	super();
	// TODO Auto-generated constructor stub
}
public Object map(Object object) {
	// TODO Auto-generated method stub
	return null;
}

}
