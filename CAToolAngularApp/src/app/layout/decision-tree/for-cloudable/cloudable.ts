export class CloudableRule{
    cloudableRuleId:number;
    questionId:number;
    cloudableRule:String;
    executionOrder:number;
    questionText:String;
   constructor(questionId,cloudableRule,executionOrder,questionText){
        this.questionId=questionId;
       this.cloudableRule=cloudableRule;
        this.executionOrder=executionOrder;
        this.questionText=questionText;
    }
}