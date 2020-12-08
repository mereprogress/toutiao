package com.example.toutiao.async;

public enum EventType {
    like(1),Message(2);

    private int index;
    EventType(int i) {
        this.index=i;
    }

    public int getIndex() {
        return index;
    }
}
