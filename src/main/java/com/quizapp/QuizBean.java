package com.quizapp;

import com.quizapp.model.Question;
import com.quizapp.model.Quiz;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean
public class QuizBean {
    private Quiz quiz;
    private int currentIndex;
    private int score;
    private String selectedAnswer;

    public void init() {
        List<Question> questions = new ArrayList<>();
        List<String> possibleAnswers = new ArrayList<>();
        possibleAnswers.add("A");
        possibleAnswers.add("B");
        possibleAnswers.add("C");
        possibleAnswers.add("D");
        questions.add(new Question("What is the capital of France?", "B", possibleAnswers));
        questions.add(new Question("What is the largest country in the world by land area?", "A", possibleAnswers));
        questions.add(new Question("What is the currency of Japan?", "C", possibleAnswers));
        quiz = new Quiz(questions);
        currentIndex = 0;
        score = 0;
    }

    public Question getCurrentQuestion() {
        return quiz.getQuestions().get(currentIndex);
    }

    public List<String> getPossibleAnswers() {
        List<String> possibleAnswers = getCurrentQuestion().getPossibleAnswers();
        Collections.shuffle(possibleAnswers); // shuffle the list to randomize answer order
        return possibleAnswers;
    }

    public void answerQuestion() {
        if (selectedAnswer.equals(getCurrentQuestion().getCorrectAnswer())) {
            score++;
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct!", null));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrect", null));
        }
        selectedAnswer = null;
        currentIndex++;
        if (currentIndex == quiz.getQuestions().size()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Quiz Complete!", null));
            currentIndex = 0;
            score = 0;
        }
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
