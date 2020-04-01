package edu.dp;

import java.util.ArrayList;
import java.util.List;

public class ListSelectionListener implements IObserver, IMediator {

    private ESelectionState state = null;
    private List<ISubject> colleagues = new ArrayList<>();

    @Override
    public void notify(Object colleague, Object value) {

    }

    @Override
    public void update(Object value) {
        state = (ESelectionState) value;
    }
}
