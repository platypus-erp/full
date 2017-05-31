package org.platypus.erp.notification;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.platypus.api.Record;
import org.platypus.api.fields.LongField;
import org.platypus.api.query.QueryPath;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import static org.platypus.erp.notification.NotificationStatus.READ;
import static org.platypus.erp.notification.NotificationStatus.UNREAD;

/**
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class Notification implements Record{
    public static final String TABLE = "notification";
    public static final int PRIORITY_MAXIMAL = 9999;
    public static final int PRIORITY_MINIMAL = 0;
    public static final int PRIORITY_NORMAL = 4500;
    @Column
    @NotBlank
    private String message;
    @Column
    @NotNull
    private boolean hide;
    @Column
    @Range(min = 0, max = 9999)
    @NotNull
    private int priority;
    @Column
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    public Notification() {
    }

    private Notification(String title, String message) {
//        this.name = title;
        this.message = message;
    }

    public static Notification createClassicNotification(String title, String message) {
        return new Notification(title, message);
    }

    @PrePersist
    private void prePersist() {
        this.priority = PRIORITY_NORMAL;
        this.hide = false;
        this.status = UNREAD;
    }

    @Override
    public LongField id() {
        return null;
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public QueryPath getPath() {
        return null;
    }

    @Override
    public void setPath(QueryPath queryPath) {

    }

    @Override
    public QueryPath resolve(QueryPath queryPath) {
        return null;
    }

    public String getMessage() {
        return message;
    }

    public Notification setMessage(String message) {
        this.message = message;
        return this;
    }

    public boolean isHide() {
        return hide;
    }

    public Notification setHide(boolean hide) {
        this.hide = hide;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public Notification setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void markAsRead() {
        this.status = READ;
    }

    public void markAsUnRead() {
        this.status = UNREAD;
    }
}
