package com.example.thejavatest;

public class Study {
    private StudyStatus status;

    private String name;
    private int limit;
    public Study() {
        this.status = StudyStatus.DRAFT;
    }

    public Study(int limit, String name) {
        this.name = name;
        this.limit = limit;
    }

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit은 0보다 커야 한다.");
        }
        this.limit = limit;
    }


    public String getName() {
        return name;
    }

    public StudyStatus getStatus() {
        return status;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "Study{" +
                "status=" + status +
                ", name='" + name + '\'' +
                ", limit=" + limit +
                '}';
    }
}
