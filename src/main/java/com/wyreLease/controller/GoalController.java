package com.wyreLease.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import com.wyreLease.model.GoalReport;
import com.wyreLease.service.GoalService;

@Controller
@SessionAttributes("goal")
public class GoalController {

	@Autowired
	GoalService goalService;

	@RequestMapping(value = "/addGoal", method = RequestMethod.GET)
	public String addGoal(Model model, HttpSession session) {
		Goal goal = (Goal) session.getAttribute("goal");
		if(goal==null){
			goal=new Goal(10);
		}
		model.addAttribute("goal", goal);
		return "addGoal";
	}

	@RequestMapping(value = "/addGoal", method = RequestMethod.POST)
	public String createGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result) {

		if (result.hasErrors()) {
			return "addGoal";
		} else {
			goalService.save(goal);
		}
		System.out.println("minutes updated" + goal.getMinutes());
		return "redirect:addMinutes.html";
	}

	@RequestMapping(value = "/getGoals", method = RequestMethod.GET)
	public String getGoals(Model model) {
		List<Goal> goals = goalService.findAll();
		model.addAttribute("goals", goals);
		return "getGoals";
	}

	@RequestMapping(value = "/getGoalReports", method = RequestMethod.GET)
	public String getGoalReports(Model model) {
		List<GoalReport> goalReports = goalService.findAllReports();
		model.addAttribute("goalReports", goalReports);
		return "getGoalReports";
	}
}
