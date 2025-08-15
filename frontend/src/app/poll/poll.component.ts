import { Component, OnInit } from '@angular/core';
import { Poll } from '../poll.models';
import { NgModule } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common'; 
import { PollService } from '../poll.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-poll',
  standalone: true,
  imports: [NgFor,CommonModule,FormsModule],
  templateUrl: './poll.component.html',
  styleUrl: './poll.component.css'
})
export class PollComponent implements OnInit{
polls : Poll[]=[];
newPoll : Poll = {
id : 0 , 
question :'',
options : [
  { options : '' , voteCount :0},
  
  { options : '' , voteCount :0}
]
  }

constructor(private pollService : PollService){}
ngOnInit(): void {
    this.loadPolls()
}
loadPolls(){
  this.pollService.getPolls().subscribe({
    next : (data)=> {
      this.polls=data
      console.log(data)
    },
    error : (error)=>{
      console.log("error while fatching data",error)
    }
  })
}
trackByIndex(index : number):number{
  return index
}
createPoll(){
  this.pollService.createPoll(this.newPoll).subscribe({
    next : (createPoll)=>{
      this.polls.push(createPoll)
    },
    error : (error)=> {
      console.log("error while creating poll")
    }
  
})
}
resetPoll(){
this.newPoll = {
id : 0 , 
question :'',
options : [
  { options : '' , voteCount :0},
  
  { options : '' , voteCount :0}
]
  }
}
vote(id :number, optionIndex : number){
  this.pollService.createVote(id,optionIndex).subscribe({
    next :()=>{
      const poll = this.polls.find(p => p.id === id);
      if(poll){
        poll.options[optionIndex].voteCount++;
      }
    },
    error : (error)=>{
      console.log(error)
    }
  })
}
addPoll(){
  this.newPoll.options.push({options : '' , voteCount : 0})
}
}
