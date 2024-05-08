package org.taskmanagement401.entity;

public enum Priority {
    HIGH(3),
    MEDIUM(2),
     LOW(1);
    private int statusPriority;

    Priority(int statusPriority) {
        this.statusPriority = statusPriority;
    }

    public int getStatusPriority() {
        return statusPriority;
    }

    public void setStatusPriority(int statusPriority) {
        this.statusPriority = statusPriority;
    }
}
