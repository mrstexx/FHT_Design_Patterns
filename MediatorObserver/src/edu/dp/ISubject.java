package edu.dp;

public interface ISubject {

    void register(IObserver participant);

    void unregister(IObserver participant);

    void notify(Object value, Object data);
}
