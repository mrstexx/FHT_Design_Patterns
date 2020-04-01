package edu.dp;

import java.util.ArrayList;
import java.util.List;

public class ButtonDialog implements ISubject {
    private Button addButton;
    private Button removeButton;
    private Button updateButton;
    private List<IObserver> participants = new ArrayList<>();

    public ButtonDialog() {
        // set also default values when first time open
        this.addButton = new Button("Add New");
        this.removeButton = new Button("Remove all selected", true);
        this.updateButton = new Button("Update selected", true);
    }

    @Override
    public void register(IObserver participant) {
        participants.add(participant);
    }

    @Override
    public void unregister(IObserver participant) {
        participants.remove(participant);
    }

    @Override
    public void notify(Object value) {
        for (IObserver observer : participants) {
            observer.update(value);
        }
    }
}
