package com.cattool.application.exception;

public class ExceptionMessages {

	 public static final String WrongPassword = "wrong password" ;
	 public static final String InvalidName="Invalid user. User name is wrong";
	 public static final String AddUserError="Server error while adding users details";
	 public static final String DeletsUser="Error while Deleting users ";
	 public static final String UpdateUser="Error in updating user details, it might happen while some information is missing or user_id wrong or not present.";
	 public static final String UpdateUserPassword="Error in password updating";
	 public static final String UpdatePassword="Error in password updating,invalid user name";
	 public static final String DeactivateUser="Error while deactivating user,may be occure because of db or something wrong with the userid";
     public static final String GetUserDetails="Error in getting users";
     public static final String GetQuestion="Error while getting Assessment Questions";
     public static final String GetQuestionByClientName ="Error while getting Questions By client Name";
     public static final String SaveQuestion ="Error while saving Assessment Questions";
     public static final String DeleteQuestion = "Error while deleting question ";
     public static final String UpdateQuestion ="Error while updating questions";
     public static final String CloudableQuestion ="Error while getting cloudable Questions";
     public static final String MigrationPattern = "Error while getting migration pattern for dicision tree";
     public static final String CloudProviderPattern ="Error while getting cloud provider pattern for dicision tree";
     
}
