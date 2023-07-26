/**
 * Name: Jimmy Tran
 * G#: G01130635
 * Name: Jacob Groen
 * G#: G01149885
 * Name: Kelvin Lu
 * G#: G01194210
 * Course-Section: SWE645-001
 * Assignment: #3
 * Main handler of HTTP requests, contains methods with specific operations mapped to different Request methods.
 **/

package com.surveyApp.survey;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        super();
        this.surveyService = surveyService;
    }

    // get all surveys
    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    // create a survey
    @PostMapping("/create")
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
        return new ResponseEntity<Survey>(surveyService.saveSurvey(survey), HttpStatus.CREATED);
    }

    // update a survey with matching ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSurvey(@PathVariable Long id, @RequestBody Survey surveyData) {
        Survey updatedSurvey = surveyService.updateSurveyById(id, surveyData);

        if (updatedSurvey != null) {
            surveyService.saveSurvey(updatedSurvey);
            return new ResponseEntity<String>("Survey with ID " + id + " updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Update failed.", HttpStatus.NOT_FOUND);
        }
    }

    // delete a survey
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSurvey(@PathVariable Long id) {
        boolean surveyDeleted = surveyService.deleteSurvey(id);

        if (surveyDeleted) {
            return new ResponseEntity<String>("Survey deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Survey with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
