package edu.dp;

public interface IMediator<T> {

    void notify(T colleague, Object value, Object data);

    void register(T colleague);
}
