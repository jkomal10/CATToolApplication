package com.cattool.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cattool.application.entity.QuestionOption;

public interface OptionRepository extends JpaRepository<QuestionOption, Long> {

}
