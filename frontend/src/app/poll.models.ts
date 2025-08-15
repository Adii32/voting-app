import { NumberValueAccessor } from "@angular/forms";
export interface OptionVote{
options: String;
 
  voteCount : number;
}
export interface Poll {
id : number;
question : String;
options : OptionVote[];
}
