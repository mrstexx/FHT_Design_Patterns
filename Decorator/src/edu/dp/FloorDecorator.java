package edu.dp;

public class FloorDecorator extends AbstractDecorator {
    @Override
    public void makeHouse() {
        super.makeHouse();
        // decorating now
        System.out.println("***Floor decorator is in action***");
        addFloor();
        // you can put whatever here
    }

    private void addFloor() {
        System.out.println("I am making an additional floor on top of it.");
    }
}
