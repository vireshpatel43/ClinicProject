
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 2162642
 */
public class SelfDiagnosis {

    public boolean scheduleAppoint;
    private String ConsoleAnswer;
    private boolean answer1 = false;
    private boolean answer2 = false;
    private boolean answer3 = false;
    private boolean answer4 = false;
    private boolean answer5 = false;
    private boolean answer6 = false;
    private boolean answer7 = false;
    private boolean answer8 = false;
    private boolean answer9 = false;
    private boolean answer10 = false;

    public void Question1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is your Nose Congested?");
        ConsoleAnswer = sc.nextLine();
        if (ConsoleAnswer.equalsIgnoreCase("T")) {
            answer1 = true;
        } else if (ConsoleAnswer.equalsIgnoreCase("F")) {
            answer1 = false;
        } else {
            System.out.println("Invalid Answer.");
            System.out.println("");
        }
    }

    public void Question2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you have a Fever? \\ Note: Temperature >= 38 degrees celsius");
        ConsoleAnswer = sc.nextLine();
        if (ConsoleAnswer.equalsIgnoreCase("T")) {
            answer2 = true;
        } else if (ConsoleAnswer.equalsIgnoreCase("F")) {
            answer2 = false;
        } else {
            System.out.println("Invalid Answer.");
            System.out.println("");
        }
    }

    public void Question3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you have a Sore Throat?");
        ConsoleAnswer = sc.nextLine();
        if (ConsoleAnswer.equalsIgnoreCase("T")) {
            answer3 = true;
        } else if (ConsoleAnswer.equalsIgnoreCase("F")) {
            answer3 = false;
        } else {
            System.out.println("Invalid Answer.");
            System.out.println("");
        }
    }

    public void Question4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you suffering from Excessive Fatigue?");
        ConsoleAnswer = sc.nextLine();
        if (ConsoleAnswer.equalsIgnoreCase("T")) {
            answer4 = true;
        } else if (ConsoleAnswer.equalsIgnoreCase("F")) {
            answer4 = false;
        } else {
            System.out.println("Invalid Answer.");
            System.out.println("");
        }
    }

    public void Question5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Has your Sense of Smell or Taste Disappeared?");
        ConsoleAnswer = sc.nextLine();
        if (ConsoleAnswer.equalsIgnoreCase("T")) {
            answer5 = true;
        } else if (ConsoleAnswer.equalsIgnoreCase("F")) {
            answer5 = false;
        } else {
            System.out.println("Invalid Answer.");
            System.out.println("");
        }
    }

    public void Question6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you have a Dry Cough? (Without Mucus)");
        ConsoleAnswer = sc.nextLine();
        if (ConsoleAnswer.equalsIgnoreCase("T")) {
            answer6 = true;
        } else if (ConsoleAnswer.equalsIgnoreCase("F")) {
            answer6 = false;
        } else {
            System.out.println("Invalid Answer.");
            System.out.println("");
        }
    }

    public void Question7() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you have a Wet Cough? (With Mucus)");
        ConsoleAnswer = sc.nextLine();
        if (ConsoleAnswer.equalsIgnoreCase("T")) {
            answer7 = true;
        } else if (ConsoleAnswer.equalsIgnoreCase("F")) {
            answer7 = false;
        } else {
            System.out.println("Invalid Answer.");
            System.out.println("");
        }
    }

    public void Question8() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you suffering from Chills?");
        ConsoleAnswer = sc.nextLine();
        if (ConsoleAnswer.equalsIgnoreCase("T")) {
            answer8 = true;
        } else if (ConsoleAnswer.equalsIgnoreCase("F")) {
            answer8 = false;
        } else {
            System.out.println("Invalid Answer.");
            System.out.println("");
        }
    }

    public void Question9() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you Sneezing Frequently?");
        ConsoleAnswer = sc.nextLine();
        if (ConsoleAnswer.equalsIgnoreCase("T")) {
            answer9 = true;
        } else if (ConsoleAnswer.equalsIgnoreCase("F")) {
            answer9 = false;
        } else {
            System.out.println("Invalid Answer.");
            System.out.println("");
        }
    }

    public void Question10() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you have Diarrhea?");
        ConsoleAnswer = sc.nextLine();
        if (ConsoleAnswer.equalsIgnoreCase("T")) {
            answer10 = true;
        } else if (ConsoleAnswer.equalsIgnoreCase("F")) {
            answer10 = false;
        } else {
            System.out.println("Invalid Answer.");
            System.out.println("");
        }
    }

    public void Inconclusive() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Self-Diagnosis Result: Inconclusive");
        System.out.println("Please seek Medical Consultation.");
        System.out.println("It is Highly Recommended to Create an Appointment with a Medical Professional.");
    }

    public void DiagnosisProgram() {
        System.out.println("Welcome to the Self-Diagnosis Program.");
        System.out.println("Answer all of the following questions by inputing either 'T' for True or 'F' for False");
        System.out.println("");
        Question1();
        Question2();
        Question3();
        Question4();
        Question5();
        Question6();
        Question7();
        Question8();
        Question9();
        Question10();
        System.out.println("");

        if (answer10 == true) {
            System.out.println("Self-Diagnosis Result: Gastro");
            System.out.println("Remember to seek Medical Consultation if you are unsatisifed with this Self-Diagnosis.");
        }
        else if (answer1 == true && answer3 == true && answer7 == true && answer9 == true) {
            System.out.println("Self-Diagnosis Result: Cold");
            System.out.println("Remember to seek Medical Consultation if you are unsatisifed with this Self-Diagnosis.");
        }
        else if (answer2 == true && answer3 == true && answer4 == true && answer6 == true && answer8 == true) {
            System.out.println("Self-Diagnosis Result: Flu");
            System.out.println("Remember to seek Medical Consultation if you are unsatisifed with this Self-Diagnosis.");
        }
        else if (answer2 == true && answer4 == true && answer5 == true && answer6 == true) {
            System.out.println("Self-Diagnosis Result: Covid-19");
            System.out.println("Remember to seek Medical Consultation if you are unsatisifed with this Self-Diagnosis.");
        } else {
            Inconclusive();
        }
    }


    public boolean isScheduleAppoint() {
        return scheduleAppoint;
    }

    public void setScheduleAppoint(boolean scheduleAppoint) {
        this.scheduleAppoint = scheduleAppoint;
    }

    
}
