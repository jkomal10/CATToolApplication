import { AssessmentQuestions } from "./Question";

export class QuestionOption{

    optionId:number;
    questionText:String;
    //optionText:String;
    optionText : Array<string>=[];
    public assessmentQuestions?:AssessmentQuestions;
    
    // constructor(optionId:number,questionText:String,optionText:String,question:Question)
    // {
    //     this.optionId=optionId;
    //     this.optionText=optionText;
    //     this.questionText=questionText;
    //     this.question=question;

    // }

    
}