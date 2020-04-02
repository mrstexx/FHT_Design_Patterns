package edu.dp;

public class Main {

    public static void main(String[] args) {
        System.out.println("***Decorator pattern Demo***");
        ConcreteComponent withoutDecorator = new ConcreteComponent();
        withoutDecorator.makeHouse();
        System.out.println("__________________");
        // Using a decorator to add floor
        System.out.println("Using a Floor decorator now.");
        FloorDecorator floorDecorator = new FloorDecorator();
        floorDecorator.setComponent(withoutDecorator);
        floorDecorator.makeHouse();
        System.out.println("__________________");
        // Using a decorator to add floor to original house and then paint it
        System.out.println("Using a Paint decorator now.");
        PaintDecorator paintDecorator = new PaintDecorator();
        // Adding results from floor decorator
        paintDecorator.setComponent(floorDecorator);
        paintDecorator.makeHouse();
        System.out.println("__________________");
    }
}
