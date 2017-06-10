package org.platypus.api.annotations;

import org.platypus.api.BaseModel;
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
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PACKAGE)
public @interface Service {

    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.TYPE)
    @interface Super{}

    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.METHOD)
    @interface One {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.METHOD)
    @interface Multi {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.METHOD)
    @interface Empty {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.METHOD)
    @interface NoLogged {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.METHOD)
    @interface InternalService {
    }
}
