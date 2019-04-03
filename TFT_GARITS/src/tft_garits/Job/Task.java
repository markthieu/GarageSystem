package tft_garits.Job;

import java.util.ArrayList;
import tft_garits.Stock.Part;

public class Task {

    private String description;
    private int task_no;
    private String status;
    private ArrayList<Part> parts;
    
    public Task(String description, int task_no, ArrayList<Part> parts) {
        this.description = description;
        this.task_no = task_no;
        this.parts = parts;
    }
    
    public Task(String description, int task_no) {
        this.description = description;
        this.task_no = task_no;
    }
    
    @Override
    public String toString(){
        return description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTask_no() {
        return task_no;
    }

    public void setTask_no(int task_no) {
        this.task_no = task_no;
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }
}