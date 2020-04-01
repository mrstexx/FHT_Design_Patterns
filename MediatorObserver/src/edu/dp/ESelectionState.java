package edu.dp;

public enum ESelectionState {
    NONE(0),
    SINGLE(1),
    MULTI(2);

    private int value;

    ESelectionState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ESelectionState getState(int value) {
        if (value == ESelectionState.NONE.getValue()) {
            return ESelectionState.NONE;
        }
        if (value == ESelectionState.SINGLE.getValue()) {
            return ESelectionState.SINGLE;
        }
        return ESelectionState.MULTI;
    }
}
