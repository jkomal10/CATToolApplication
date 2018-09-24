export interface IUser{   

    questionId : number;
    questionText : string;
    questionDescription : string;
    questionType : string;
    questionDisplayOrder : number;
    numberOfOption : number;
    isActive : boolean;
    isDelete : boolean;
    assessmentTypeForMigration : string;
    assessmentTypeForCloudProvider : string;
    assessmentTypeForCloudable : string;
}