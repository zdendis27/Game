package game;

import java.io.File;
import java.util.ArrayList;

public class Person {
    private int id;
    private String name;
    private String wantedItem;
    private boolean wantFight;
    private boolean wantToSolve;
    private String dialoguePath;
    private String answer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getWantedItem() {
        return wantedItem;
    }

    public void setWantedItem(String wantedItem) {
        this.wantedItem = wantedItem;
    }

    public boolean isWantFight() {
        return wantFight;
    }

    public void setWantFight(boolean wantFight) {
        this.wantFight = wantFight;
    }

    public boolean isWantToSolve() {
        return wantToSolve;
    }

    public void setWantToSolve(boolean wantToSolve) {
        this.wantToSolve = wantToSolve;
    }

    public String getDialoguePath() {
        return dialoguePath;
    }

    public void setDialoguePath(String dialoguePath) {
        this.dialoguePath = dialoguePath;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Person(int id, String name, String wantedItem, boolean wantFight, boolean wantToSolve, String dialoguePath, String answer) {
        this.id = id;
        this.name = name;
        this.wantedItem = wantedItem;
        this.wantFight = wantFight;
        this.wantToSolve = wantToSolve;
        this.dialoguePath = dialoguePath;
        this.answer = answer;
    }
}
