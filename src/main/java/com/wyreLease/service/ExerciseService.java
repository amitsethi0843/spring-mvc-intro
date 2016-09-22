package com.wyreLease.service;

import java.util.List;

import com.wyreLease.model.Activity;
import com.wyreLease.model.Exercise;

public interface ExerciseService {

	List<Activity> findAllActivities();

	Exercise save(Exercise exercise);

}