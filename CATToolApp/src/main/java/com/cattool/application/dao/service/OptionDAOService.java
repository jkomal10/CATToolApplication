package com.cattool.application.dao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattool.application.dao.OptionDAO;
import com.cattool.application.entity.QuestionOption;
import com.cattool.application.repository.OptionRepository;

@Component
public class OptionDAOService {
	
	@Autowired
	private OptionRepository optionRepository; 
	
	public List<OptionDAO> getAll(){
		List<OptionDAO> optionDaoList=new ArrayList<OptionDAO>();
		List<QuestionOption> optionList=optionRepository.findAll();
		
		return toGetAll(optionList,optionDaoList);
	}
	
	public List<OptionDAO> toGetAll(List<QuestionOption> optionList,List<OptionDAO> optionDaoList){
		for(QuestionOption questionOption:optionList)
		{
			optionDaoList.add(toDao(questionOption));
		}
		return optionDaoList;
	}

	private OptionDAO toDao(QuestionOption questionOption) {
		OptionDAO optionDao=new OptionDAO();
		optionDao.setOptionId(questionOption.getOptionId());
		optionDao.setOptionText(questionOption.getOptionText());
		optionDao.setQuestionId(questionOption.getQuestionId());
		return optionDao;
	}
	
	public QuestionOption saveQuestionOption(QuestionOption questionOption) {
		return optionRepository.save(questionOption);
		
	}

}
