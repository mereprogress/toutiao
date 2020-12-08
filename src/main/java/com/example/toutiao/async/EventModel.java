package com.example.toutiao.async;

public class EventModel {
    private EventType type;
    private int userId;
    private int entityId;
    private int typeId; //可以是对不同的喜欢，对news 对评论
    private int entityOwnerId;

    public EventType getType() {
        return type;
    }

    public EventModel setType(EventType type) {
        this.type = type;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public EventModel setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getEntityId() {
        return entityId;
    }

    public EventModel setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public int getTypeId() {
        return typeId;
    }

    public EventModel setTypeId(int typeId) {
        this.typeId = typeId;
        return this;
    }

    public int getEntityOwnerId() {
        return entityOwnerId;
    }

    public EventModel setEntityOwnerId(int entityOwnerId) {
        this.entityOwnerId = entityOwnerId;
        return this;
    }
}
