package com.nerdysoft.model;

import java.util.List;
import java.util.Objects;

public class Room {
    private int id;
    private List<Pair> room;

    public Room() {
    }

    public Room(List<Pair> room) {
        this.room = room;
    }

    public Room(int id, List<Pair> room) {
        this.id = id;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pair> getRoom() {
        return room;
    }

    public void setRoom(List<Pair> room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        Room room = (Room) o;
        return id == room.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
