package com.cattool.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cattool.application.dao.AnswersDAO;
import com.cattool.application.dao.service.AnswesDAOService;
import com.cattool.application.repository.AnswersRepository;
import com.cattool.application.repository.ApplicationRepository;

@Service
public class AnswersService {

	@Autowired
	AnswersRepository answersRepository;

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	AnswesDAOService answesDAOService;

	public List<AnswersDAO> getAllAnswers() {
		return answesDAOService.getAll();
	}

	public List<AnswersDAO> GetSingleApplication(int applicationId) {

		return answesDAOService.GetSingleApplication(applicationId);
	}

	public void saveAnswers(List<AnswersDAO> AnswersList) {

		answesDAOService.saveAnswers(AnswersList);
	}

	public void updateAns(List<AnswersDAO> answerList) {

		answesDAOService.updateAns(answerList);

	}

}
