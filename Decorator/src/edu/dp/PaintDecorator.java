package edu.dp;

public class PaintDecorator extends AbstractDecorator {
    @Override
    public void makeHouse() {
        super.makeHouse();
        // decorating now
        System.out.println("***Paint decorator is in action now***");
        paintHouse();
        // You can add here additional stuffs as per your need
    }

    private void paintHouse() {
        System.out.println("Now I am painting the house.");
    }
}
