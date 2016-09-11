package com.wyreLease.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wyreLease.model.Activity;

@Service("exerciseService")
public class ExerciseService implements ExerciseServiceInterface {
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
}
