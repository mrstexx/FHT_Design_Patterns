package edu.dp;

import java.util.ArrayList;
import java.util.List;

public class ListDialog extends AbstractDialog implements ISubject {
    private List<ListItem> allItems;
    private List<ListItem> selectedItems;
    private List<IObserver> participants = new ArrayList<>();

    public ListDialog(IMediator<?> mediator) {
        super(mediator);
        allItems = new ArrayList<>();
        selectedItems = new ArrayList<>();
    }

    public void selectItem(int id) {
        selectedItems.add(allItems.get(id));
        notify(ESelectionState.getState(getSelectedCount()), null);
    }

    public void deselectItem(int id) {
        selectedItems.remove(allItems.get(id));
        notify(ESelectionState.getState(getSelectedCount()), null);
    }

    private void addIListItem(String text) {
        allItems.add(new ListItem(text));
    }

    private void removeItem(int id) {
        selectedItems.remove(allItems.get(id));
        allItems.remove(id);
    }

    private void updateItem(int id, String text) {
        allItems.get(id).setText(text);
    }

    public int getSelectedCount() {
        return selectedItems.size();
    }

    public List<ListItem> getSelectedItems() {
        return selectedItems;
    }

    public List<ListItem> getAllItems() {
        return allItems;
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
        EButtonAction action = (EButtonAction) value;
        if (action.equals(EButtonAction.ADD)) {
            addIListItem((String) data);
        } else if (action.equals(EButtonAction.REMOVE)) {
            removeSelectedItems();
        } else if (action.equals(EButtonAction.UPDATE)) {
            // only element in the list has id 0
            updateItem(0, (String) data);
        }
        logger();
    }

    private void removeSelectedItems() {
        for (int i = 0; i < selectedItems.size(); i++) {
            removeItem(i);
        }
    }

    private void logger() {
        System.out.println("******** List Dialog ********");
        System.out.println("Number of items: " + allItems.size());
        System.out.println("Number of selected items: " + selectedItems.size());
    }
}
