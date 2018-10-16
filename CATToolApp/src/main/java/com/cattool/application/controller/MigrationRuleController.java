package com.cattool.application.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cattool.application.entity.Migration;
import com.cattool.application.service.MigrationRuleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/migrationRule")
public class MigrationRuleController {
	
	@Autowired
	MigrationRuleService migrationRuleService;
	
	@GetMapping("/getAll")
	public List<Migration> getAllApplication()
	{
		return migrationRuleService.getAllmigrationRule();
	}

}
