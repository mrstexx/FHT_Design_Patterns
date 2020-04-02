package edu.dp;

import java.util.ArrayList;
import java.util.List;

public class ListSelectionListener implements IObserver, IMediator<AbstractDialog> {

    private ESelectionState state = null;
    private List<AbstractDialog> colleagues = new ArrayList<>();

    @Override
    public void notify(AbstractDialog dialog, Object value, Object data) {
        if (colleagues.contains(dialog)) {
            colleagues.forEach(colleague -> {
                // don't send to ourselves
                if (!colleague.equals(dialog)) {
                    colleague.receive(value, data);
                }
            });
        }
    }

    @Override
    public void register(AbstractDialog colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void update(Object sender, Object value, Object data) {
        state = (ESelectionState) value;
        notify((AbstractDialog) sender, value, data);
    }
}
