package org.platypus.api.annotations;

import org.platypus.api.BaseModel;
import org.platypus.api.Record;
import org.platypus.api.service.PlatypusService;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chmuchme
 * @since 0.1
 * on 01/06/17.
 */

public interface ServiceInfoType extends ServiceInfo{
    default Class<? extends BaseModel> model(){
        return this.getClass().getAnnotation(ServiceInfo.class).model();
    }
    default Class<? extends PlatypusService<? extends Record>> classHolder(){
        return this.getClass().getAnnotation(ServiceInfo.class).classHolder();
    }

    @Override
    default Class<ServiceInfo> annotationType() {
        return ServiceInfo.class;
    }
}
