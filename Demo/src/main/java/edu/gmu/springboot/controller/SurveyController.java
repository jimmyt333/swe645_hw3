package edu.gmu.springboot.controller;

import edu.gmu.springboot.model.Survey;
import edu.gmu.springboot.service.SurveyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id) {
        return surveyService.getSurveyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return surveyService.saveSurvey(survey);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Long id, @RequestBody Survey surveyData) {
        return surveyService.getSurveyById(id)
                .map(existingSurvey -> {
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
                    return ResponseEntity.ok(surveyService.saveSurvey(existingSurvey));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        surveyService.deleteSurvey(id);
        return ResponseEntity.noContent().build();
    }
}
