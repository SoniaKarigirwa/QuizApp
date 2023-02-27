package com.quizapp.model;

import java.util.List;

public class Question {
    private String questionText;
    private String correctAnswer;
    private List<String> possibleAnswers;

    public Question(String questionText, String correctAnswer, List<String> possibleAnswers) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.possibleAnswers = possibleAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }



    public String getQuestion() {
        return questionText;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }
}
