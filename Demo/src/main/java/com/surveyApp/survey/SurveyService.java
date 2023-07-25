package com.surveyApp.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surveyApp.survey.ResourceNotFoundException;
import com.surveyApp.survey.Survey;
import com.surveyApp.survey.SurveyRepository;

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

    public Optional<Survey> getSurveyById(Long id) {

        Optional<Survey> survey = surveyRepository.findById(id);

        if (survey.isPresent()) {
            return surveyRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("Survey", "Id", id);
        }
    }

    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    public void deleteSurvey(Long id) {
        surveyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Survey", "Id", id));
        surveyRepository.deleteById(id);
    }
}
