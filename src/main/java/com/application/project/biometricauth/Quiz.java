package com.application.project.biometricauth;
//This part of the GUI uses java swing
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{
    JTextField prompt = new JTextField();//this prompt shows up everytime an answer is selected, it either says 'correct' or 'incorrect'
    JTextField totalCorrectAnswers = new JTextField();//this textfield pops up at the end showing the amount of correct answers the user got in the quiz
    JFrame gui = new JFrame();//the gui frame itself
    JTextField questionNumber = new JTextField();//the question number the user is on
    JTextField programName = new JTextField();//just a label at the bottom with our program name
    JTextArea currentQuestion = new JTextArea();//the question being displayed
    JButton A = new JButton();//the buttons the user presses
    JButton B = new JButton();
    JButton C = new JButton();
    JButton D = new JButton();

    char[] answers;//the program makes use of arrays to store the questions and answers
    String[] questions;
    int totalQuestions;
    String[][] options;


    int i;//this is the index that will be used to check when the quiz ends
    int correctAnswers =0;//this will be incremented everytime a correct answer is chosen
    char answer;// the answer chosen will be assigned to this variable depending on the button pressed


    public void setQuestionsAnswers(){

        questions = new String[]{//array storing questions
                "When did the Suprema data breach occur?",
                "Are all types of biometric data equally unique/secure among people?",
                "What would a government do with someone's biometric data?",
                "Which of the following can be used for biometric authentication?",
                "Can biometric authentication systems be bypassed?",
                "Which of these is a reason Suprema's biometric lock system got breached?",
                "What was Suprema's biometric lock system called?",
                "Why may private companies want a customer's biometric data?",
                "Which of these is a way in which a malicious person can bypass biometric authentication?",
                "What foreign language does the word 'biometric' come from?"
        };
        totalQuestions = questions.length;//the amount of questions
        options = new String[][]{//2D array storing answers
                {"2022", "2021", "2020", "2019"},//D
                {"No, some types are more secure", "I don't know", "Yes, they are equal", "There is only one type"},//A
                {"Sell it", "Surveillance", "Ignore it", "Use it for advertising"},//B
                {"Foot size", "Hair", "IRIS", "Nails"},//C
                {"It's impossible", "No", "Yes", "I'm not sure"},//C
                {"It was outdated", "It physically broke", "Unsecure database", "A malicious employee"},//C
                {"Bio-star 2", "Bio-star 1", "Star-struck 1", "Metric-star 1"},//A
                {"To catch criminals", "Authentication", "To look at it", "To destroy it"},//B
                {"Synthetic copy", "Social-engineering", "Stealing from database", "All of the above"},//D
                {"French", "Greek", "Latin", "Arabic"}//B
        };
        answers = new char[]{//array storing correct answer for each question
                'D',
                'A',
                'B',
                'C',
                'C',
                'C',
                'A',
                'B',
                'D',
                'B'
        };




    }

    public Quiz() {//constructor which arranges everything and makes the gui itself from the objects initialized above

        gui.setSize(650,650);
        gui.setTitle("biometric_dataV3.0");
        gui.getContentPane().setBackground(Color.blue);
        gui.setLayout(null);
        gui.setResizable(false);

        A.setBounds(0,100,650,100);
        A.setFont(new Font("Serif",1,35));
        A.setFocusable(false);
        A.addActionListener(this);
        A.setText("A");

        B.setBounds(0,200,650,100);
        B.setFont(new Font("Serif",1,35));
        B.setFocusable(false);
        B.addActionListener(this);
        B.setText("B");

        C.setBounds(0,300,650,100);
        C.setFont(new Font("Serif",1,35));
        C.setFocusable(false);
        C.addActionListener(this);
        C.setText("C");

        D.setBounds(0,400,650,100);
        D.setFont(new Font("Serif",1,35));
        D.setFocusable(false);
        D.addActionListener(this);
        D.setText("D");

        programName.setBounds(0,500,650,100);
        programName.setBackground(Color.blue);
        programName.setForeground(Color.white);
        programName.setFont(new Font("Viner Hand ITC",1,30));
        programName.setBorder(BorderFactory.createBevelBorder(1));
        programName.setHorizontalAlignment(JTextField.CENTER);
        programName.setText("biometric_dataV3.0");
        programName.setEditable(false);

        totalCorrectAnswers.setBounds(225,225,200,100);
        totalCorrectAnswers.setBackground(Color.black);
        totalCorrectAnswers.setFont(new Font("Serif",Font.BOLD,50));
        totalCorrectAnswers.setBorder(BorderFactory.createBevelBorder(1));
        totalCorrectAnswers.setHorizontalAlignment(JTextField.CENTER);
        totalCorrectAnswers.setEditable(false);

        prompt.setEditable(false);
        prompt.setVisible(false);
        prompt.setBounds(225,250,200,100);
        prompt.setFont(new Font("Serif",Font.BOLD,35));
        prompt.setBackground(Color.black);
        prompt.setBorder(BorderFactory.createBevelBorder(1));
        prompt.setHorizontalAlignment(JTextField.CENTER);

        questionNumber.setBounds(0,50,650,50);
        questionNumber.setBackground(Color.blue);
        questionNumber.setForeground(Color.white);
        questionNumber.setFont(new Font("Serif",1,30));
        questionNumber.setBorder(BorderFactory.createBevelBorder(1));
        questionNumber.setHorizontalAlignment(JTextField.CENTER);
        questionNumber.setEditable(false);

        currentQuestion.setBounds(0,0,650,50);
        currentQuestion.setLineWrap(true);
        currentQuestion.setWrapStyleWord(true);
        currentQuestion.setBackground(Color.blue);
        currentQuestion.setForeground(Color.white);
        currentQuestion.setFont(new Font("Serif",1,20));
        currentQuestion.setBorder(BorderFactory.createBevelBorder(1));
        currentQuestion.setEditable(false);


        gui.add(prompt);
        gui.add(A);
        gui.add(B);
        gui.add(C);
        gui.add(D);
        gui.add(currentQuestion);
        gui.add(questionNumber);
        gui.add(programName);
        gui.setVisible(true);

        setQuestionsAnswers();
        updateScreen();
    }

    public void answerChosen() {//this function is called after a button is clicked
        Timer nextQuestion = new Timer(1500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {//everytime a button is clicked, a new question has to show up
                answer = ' ';                           //this overrided method makes sure the next question is displayed correctly
                A.setEnabled(true);//buttons are enabled for the next question                 //by using the updateScreen() function which is defined below
                B.setEnabled(true);
                C.setEnabled(true);
                D.setEnabled(true);
                i++;
                updateScreen();
            }
        });
        nextQuestion.setRepeats(false);
        nextQuestion.start();
    }
    public void updateScreen() {//this function is used to update to the next question
        if(i>=totalQuestions) {//if the index i becomes larger than the amount of total questions, the quiz is ended and result is displayed
            A.setEnabled(false);//all buttons are disabled and removed from view upon the quiz ending
            B.setEnabled(false);
            C.setEnabled(false);
            D.setEnabled(false);
            A.setVisible(false);
            B.setVisible(false);
            C.setVisible(false);
            D.setVisible(false);
            questionNumber.setText("YOU GOT:");
            currentQuestion.setText("");
            float theScore = ScoreCalculator.getScore(correctAnswers, totalQuestions);//the percentage is calculated using another method in the ScoreCalculator class
            if(theScore >= 70){// if the user's score is more than 70%, the text color will be green
                totalCorrectAnswers.setForeground(Color.green);
            }
            else if(theScore < 70 && theScore >= 50){// if the user's score is less than 70% but more than or equal to 50, the text color will be yellow
                totalCorrectAnswers.setForeground(Color.yellow);
            }
            else{// if the user's score is less than 50%, the text color will be red
                totalCorrectAnswers.setForeground(Color.red);
            }
            totalCorrectAnswers.setText((String.format("%.0f", theScore))+"%");//the percentage of correct answers is displayed
            gui.add(totalCorrectAnswers);
        }
        else {//but if the index is still less than the totalQuestions, it means the quiz has not reached the end yet and the next question will be displayed
            questionNumber.setText(String.valueOf(i+1));
            currentQuestion.setText(questions[i]);
            A.setText(options[i][0]);
            B.setText(options[i][1]);
            C.setText(options[i][2]);
            D.setText(options[i][3]);
            prompt.setText("");
            prompt.setVisible(false);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {// this function is used to check if the answer the user selected is indeed correct
        A.setEnabled(false);//after each question is answered, the buttons are disabled until the next question
        B.setEnabled(false);
        C.setEnabled(false);
        D.setEnabled(false);
        if(e.getSource()==A) {//the answer variable is assigned depending on which button is pressed
            answer= 'A';}

        if(e.getSource()==B) {
            answer= 'B';}

        if(e.getSource()==C) {
            answer= 'C';}

        if(e.getSource()==D) {
            answer= 'D';}

        if(answer == answers[i]) {//if the answer chosen is correct, a prompt shows up saying 'correct'
            correctAnswers++;
            prompt.setVisible(true);
            prompt.setForeground(Color.GREEN);
            prompt.setText("CORRECT!");
        }
        else{//or else if it is wrong, then the prompt shows up saying incorrect
            prompt.setVisible(true);
            prompt.setForeground(Color.red);
            prompt.setText("WRONG!");}
        answerChosen();
    }




}