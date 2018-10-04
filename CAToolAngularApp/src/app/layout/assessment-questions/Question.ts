export class Question{

    questionId : number;
    questionText : string;
    questionDescription : string;
    questionType : string;
    questionDisplayOrder : number;
    numberOfOption : number;
    assessmentTypeForMigration : string;
    assessmentTypeForCloudProvider : string;
    assessmentTypeForCloudable : string;
    createdBy : string;
    cteatedTime : Date;
    modifiedBy : string;
    modifiedTime : Date;
    answerValues : string  [10];
}