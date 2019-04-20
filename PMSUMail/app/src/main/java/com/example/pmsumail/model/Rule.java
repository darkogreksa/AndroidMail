package com.example.pmsumail.model;

public class Rule {


    public enum Condition {
        TO,
        FROM,
        CC,
        SUBJECT
    }

    public enum Operation {
        MOVE,
        COPY,
        PASTE
    }

    private int id;
    private Condition condition;
    private Operation operation;

    public Rule() {
    }

    public Rule(int id, Condition condition, Operation operation) {
        this.id = id;
        this.condition = condition;
        this.operation = operation;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
