package edu.dp;

import java.util.ArrayList;
import java.util.List;

public class ListDialog implements ISubject {
    private List<ListItem> allItems;
    private List<ListItem> selectedItems;
    private List<IObserver> participants = new ArrayList<>();

    public ListDialog() {
        allItems = new ArrayList<>();
        selectedItems = new ArrayList<>();
    }

    public void selectItem(int id) {
        selectedItems.add(allItems.get(id));
        notify(ESelectionState.getState(getSelectedCount()));
    }

    public void deselectItem(int id) {
        selectedItems.remove(allItems.get(id));
        notify(ESelectionState.getState(getSelectedCount()));
    }

    public void addIListItem(String text) {
        allItems.add(new ListItem(text));
    }

    public void removeItem(int id) {
        selectedItems.remove(allItems.get(id));
        allItems.remove(id);
    }

    public void updateItem(int id, String text) {
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
    public void notify(Object value) {
        for (IObserver observer : participants) {
            observer.update(value);
        }
    }
}
