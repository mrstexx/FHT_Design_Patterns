package edu.dp;

import java.util.ArrayList;
import java.util.List;

public class ButtonDialog extends AbstractDialog implements ISubject {
    private Button addButton;
    private Button removeButton;
    private Button updateButton;
    private List<IObserver> participants = new ArrayList<>();

    public ButtonDialog(IMediator<?> mediator) {
        super(mediator);
        // set also default values when first time open
        this.addButton = new Button("Add New");
        this.removeButton = new Button("Remove all selected", true);
        this.updateButton = new Button("Update selected", true);
    }

    public void clickAddNew(String value) {
        if (!addButton.isDisabled()) {
            System.out.println("Clicked add button");
            notify(EButtonAction.ADD, value);
        }
    }

    public void clickRemoveSelected() {
        if (!removeButton.isDisabled()) {
            System.out.println("Clicked remove button");
            notify(EButtonAction.REMOVE, null);
        }
    }

    public void clickUpdateSelected(String value) {
        if (!updateButton.isDisabled()) {
            System.out.println("Clicked update button");
            notify(EButtonAction.UPDATE, value);
        }
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
    public void notify(Object value, Object data) {
        for (IObserver observer : participants) {
            observer.update(this, value, data);
        }
    }

    @Override
    public void receive(Object value, Object data) {
        ESelectionState state = (ESelectionState) value;
        if (state.equals(ESelectionState.NONE)) {
            addButton.enable();
            removeButton.disable();
            updateButton.disable();
        } else if (state.equals(ESelectionState.SINGLE)) {
            addButton.disable();
            removeButton.disable();
            updateButton.enable();
        } else if (state.equals(ESelectionState.MULTI)) {
            addButton.disable();
            removeButton.enable();
            updateButton.disable();
        }
        logger();
    }

    private void logger() {
        System.out.println("******** Button Dialog ********");
        System.out.println("Add Button: " + addButton.getState());
        System.out.println("Update Button: " + updateButton.getState());
        System.out.println("Remove Button: " + removeButton.getState());
    }
}
