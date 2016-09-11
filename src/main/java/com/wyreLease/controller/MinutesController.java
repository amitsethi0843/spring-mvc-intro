package com.wyreLease.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyreLease.model.Activity;
import com.wyreLease.model.Exercise;
import com.wyreLease.service.ExerciseServiceInterface;

@Controller
public class MinutesController {
	
	@Autowired
	private ExerciseServiceInterface exerciseService;

	@RequestMapping("/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {

		System.out.println(exercise.getActivity()+": " + exercise.getMinutes());
		// redirect can be used instead of forward but it would generate a new
		// request instead of forwarding the same request
		return "forward:addMoreMinutes.html";
	}

	@RequestMapping("/addMoreMinutes")
	public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("exerice add: " + exercise.getMinutes());
		return "addMinutes";
	}

	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		return exerciseService.findAllActivities();
	}
}
