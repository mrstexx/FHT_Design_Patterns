package edu.dp;

public abstract class AbstractDialog {

    private IMediator<?> mediator;

    public AbstractDialog(IMediator<?> mediator) {
        this.mediator = mediator;
    }

    public IMediator<?> getMediator() {
        return mediator;
    }

    public abstract void receive(Object value, Object data);
}
