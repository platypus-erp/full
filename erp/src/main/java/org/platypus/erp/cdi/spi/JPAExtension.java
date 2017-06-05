package org.platypus.erp.cdi.spi;

import javax.enterprise.inject.spi.Extension;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class JPAExtension implements Extension {
//    private final Logger LOG = LoggerFactory.getLogger(JPAExtension.class);
//
//    DefaultCacheManager m;
//
//    public JPAExtension() {
//        m = new DefaultCacheManager();
//    }
//
//    void beforeBeanDiscovery(@Observes BeforeBeanDiscovery bbd) {
//        LOG.info("beginning the scanning process");
//    }
//
//    <T extends AbstractEntity> void processAnnotatedType(@Observes @WithAnnotations({Entity.class}) ProcessAnnotatedType<T> pat) {
//        Set<AnnotatedField> annotatedFileds =
//                pat.getAnnotatedType().getFields().stream()
//                        .filter(at -> at.isAnnotationPresent(JoinColumn.class))
//                        .collect(toSet());
//        String target = EntityRegistry.INSTANCE.getSafeName(pat.getAnnotatedType().getJavaClass());
//        for (AnnotatedField a : annotatedFileds) {
//            JoinColumn jc = a.getAnnotation(JoinColumn.class);
//            String tableTargetName = null;
//            String columnName = jc.methodName();
//            String relType = "OTO";
//            boolean opt = a.isAnnotationPresent(NotNull.class);
//            if (a.isAnnotationPresent(ManyToOne.class)) {
//                ManyToOne mto = a.getAnnotation(ManyToOne.class);
//                relType = "MTO";
//                Class targetEntity = mto.targetEntity();
//                if (targetEntity != void.class) {
//                    tableTargetName = EntityRegistry.INSTANCE.getSafeName(targetEntity);
//                } else {
//                    tableTargetName = EntityRegistry.INSTANCE.getSafeName((Class<AbstractEntity>) a.getJavaMember().getType());
//                }
//                opt |= mto.optional();
//            } else if (a.isAnnotationPresent(OneToOne.class)) {
//                OneToOne oto = a.getAnnotation(OneToOne.class);
//                relType = "OTO";
//                Class targetEntity = oto.targetEntity();
//                if (targetEntity != void.class) {
//                    tableTargetName = EntityRegistry.INSTANCE.getSafeName(targetEntity);
//                } else {
//                    tableTargetName = EntityRegistry.INSTANCE.getSafeName((Class<AbstractEntity>) a.getJavaMember().getType());
//                }
//                opt |= oto.optional();
//            }
//            Cache<String, SimpleEntityRegistry> cache = m.getCache("ENTITY_QUICK_PROPERTY", true);
//            cache.put(target + "_" + columnName, new SimpleEntityRegistry(tableTargetName, opt, relType));
//        }
//        pat.veto();
//    }
}
