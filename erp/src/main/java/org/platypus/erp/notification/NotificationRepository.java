package org.platypus.erp.notification;

import org.platypus.api.query.SimpleQuery;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.erp.manager.AbstractPlatypusRepository;

import java.util.List;
import java.util.function.Function;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class NotificationRepository extends AbstractPlatypusRepository<Notification> {

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

    @Override
    public int count(SimpleQuery<Notification> query) {
        return 0;
    }

    @Override
    public int count(Function<Notification, PPredicate<?>> domain) {
        return 0;
    }
}
