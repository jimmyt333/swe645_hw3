/**
 * Name: Jimmy Tran
 * G#: G01130635
 * Name: Jacob Groen
 * G#: G01149885
 * Name: Kelvin Lu
 * G#: G01194210
 * Course-Section: SWE645-001
 * Assignment: #3
 * Interface that allows CRUD operations to take place on Survey entities.
 **/

package com.surveyApp.survey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
