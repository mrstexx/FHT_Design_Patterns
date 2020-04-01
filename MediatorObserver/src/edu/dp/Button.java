package edu.dp;

public class Button {
    private boolean isDisabled;
    private String label;

    public Button(String label) {
        this.label = label;
        this.isDisabled = false;
    }

    public Button(String label, boolean isDisabled) {
        this.label = label;
        this.isDisabled = isDisabled;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void disable() {
        isDisabled = true;
    }

    public void enable() {
        isDisabled = false;
    }

    public void click() {
        // on click do something
    }
}
