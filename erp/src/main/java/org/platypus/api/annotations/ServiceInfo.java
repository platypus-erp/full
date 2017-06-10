package org.platypus.api.annotations;

import org.platypus.api.BaseModel;
import org.platypus.api.Record;
import org.platypus.api.service.PlatypusService;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chmuchme
 * @since 0.1
 * on 01/06/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ServiceInfo {
    Class<? extends BaseModel> model();
    Class<? extends PlatypusService<? extends Record>> classHolder();
}
