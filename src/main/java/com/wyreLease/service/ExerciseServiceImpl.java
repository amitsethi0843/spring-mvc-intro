package com.wyreLease.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wyreLease.model.Activity;
import com.wyreLease.model.Exercise;
import com.wyreLease.repository.ExerciseRepository;

@Transactional
@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {
	
	@Autowired
	private ExerciseRepository exerciseRepository; 
	
	public List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();
		Activity run = new Activity();
		run.setDesc("Run");
		activities.add(run);
		Activity bike = new Activity();
		bike.setDesc("Bike");
		activities.add(bike);

		Activity drive = new Activity();
		drive.setDesc("Drive");
		activities.add(drive);

		return activities;
	}

	public Exercise save(Exercise exercise) {
		return exerciseRepository.save(exercise);
	}
}
