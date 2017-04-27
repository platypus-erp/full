package org.platypus.erp.notification;

import org.platypus.erp.manager.AbstractRepository;

import java.util.List;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class NotificationRepository extends AbstractRepository<Notification> {

    public NotificationRepository() {
        super(Notification.class);
    }

    public List<Notification> getUnSeenNotification() {
        return em.createNativeQuery("SELECT * FROM NOTIFICATION WHERE STATUS = 'UNREAD'", Notification.class).getResultList();
    }

    public void markAsRead(int id) {
        super.getById(id).markAsRead();
    }

    public void markAllAsRead() {
        super.getList(null).stream().forEach(n -> n.markAsRead());
    }
}
