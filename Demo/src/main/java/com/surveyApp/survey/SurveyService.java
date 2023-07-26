/**
 * Name: Jimmy Tran
 * G#: G01130635
 * Name: Jacob Groen
 * G#: G01149885
 * Name: Kelvin Lu
 * G#: G01194210
 * Course-Section: SWE645-001
 * Assignment: #3
 * Provides abstraction layer between SurveyController and SurveyRepository, handles complex operations and data flow.
 **/

package com.surveyApp.survey;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    public SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public Survey updateSurveyById(Long id, Survey surveyData) {
        Optional<Survey> optionalSurvey = surveyRepository.findById(id);

        if (optionalSurvey.isPresent()) {
            Survey existingSurvey = optionalSurvey.get();
            existingSurvey.setFirstName(surveyData.getFirstName());
            existingSurvey.setLastName(surveyData.getLastName());
            existingSurvey.setStreetAddress(surveyData.getStreetAddress());
            existingSurvey.setCity(surveyData.getCity());
            existingSurvey.setState(surveyData.getState());
            existingSurvey.setZip(surveyData.getZip());
            existingSurvey.setPhoneNumber(surveyData.getPhoneNumber());
            existingSurvey.setEmail(surveyData.getEmail());
            existingSurvey.setDateOfSurvey(surveyData.getDateOfSurvey());
            existingSurvey.setLikedMost(surveyData.getLikedMost());
            existingSurvey.setInterestedIn(surveyData.getInterestedIn());
            existingSurvey.setLikelihood(surveyData.getLikelihood());
            return existingSurvey;
        } else {
            return null;
        }
    }

    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    public boolean deleteSurvey(Long id) {
        Optional<Survey> optionalSurvey = surveyRepository.findById(id);

        if (optionalSurvey.isPresent()) {
            surveyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
