package edu.dp;

public class ConcreteComponent extends Component {
    @Override
    public void makeHouse() {
        System.out.println("Original house is complete. It is closed for modifications.");
    }
}
