package com.cattool.application.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cattool.application.entity.Migration;
import com.cattool.application.entity.MigrationRule;
import com.cattool.application.service.MigrationRuleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/migrationRule")
public class MigrationRuleController {
	
	@Autowired
	MigrationRuleService migrationRuleService;
	
	
	
	@GetMapping("/getAllMigrationRule")
	public List<MigrationRule> getAllApplication()
	{
		return migrationRuleService.getAllmigrationRule();
	}
	
	@GetMapping("/getAll/{clientId}")
	public List<Migration> getAllMigrationPattern(@PathVariable int clientId)
	{
		return migrationRuleService.getAllMigrationPatterns(clientId);
	}
	
	@PutMapping("/updateMigrationRule/{clientId}")
	public void updateMigrationRule(@RequestBody List<MigrationRule> migrationRule,@PathVariable int clientId)
	{
		migrationRuleService.updateMigrationRule(migrationRule,clientId);
	}
	
}
