package com.wyreLease.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wyreLease.model.Goal;

@Controller
@SessionAttributes("goal")
public class GoalController {
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value="/addGoal",method=RequestMethod.GET)
	public String addGoal(Model model){
		model.addAttribute("goal",new Goal(10));
		return "addGoal";
	}
	
	@RequestMapping(value="/addGoal",method=RequestMethod.POST)
	public String createGoal(@Valid @ModelAttribute ("goal") Goal goal,BindingResult result){
		
		if(result.hasErrors()){
			return "addGoal";
		}
		System.out.println("minutes updated"+goal.getMinutes());
		return "redirect:addMinutes.html";
	}
}
