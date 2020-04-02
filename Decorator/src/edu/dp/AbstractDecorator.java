package edu.dp;

public abstract class AbstractDecorator extends Component {
    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void makeHouse() {
        if (component != null) {
            // Delegating the task
            component.makeHouse();
        }
    }
}
