package org.platypus.api.annotations.model;

import org.platypus.api.BaseEntity;
import org.platypus.api.Record;
import org.platypus.api.BaseModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to define a model extending a another<br>
 * This annotation is used when a existing model don't contains a field and you need it in your module.
 * Or if you want to modify a existing.
 * <br/>
 * The value is the target model to inherit.
 * <br/>
 * <b>This annotation can only be apply above a java public class</b>
 * <br/>
 * <b>You can't inherit a model define in your current module</b>
 * <br/>
 *
 * The platypus framework generate 2 interface from your model.<br/>
 *
 * The first one is a {@linkplain Record Record}.<br>
 * This record extend all records generated with @PlatypusInherit with the same {@linkplain BaseModel} in all you module<br>
 *
 * The second is a {@linkplain BaseEntity Entity}.<br>
 * This entity extend all records generated with @PlatypusInherit with the same {@linkplain BaseModel} in all you module<br>
 *
 * 99% of the time when you use the platypus framework only the generated
 * {@linkplain Record Record} is useful
 * The generated {@linkplain BaseEntity Entity}
 * is used internally but maybe the platypus framework offer not enough feature and you need to use the lower API.
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 *
 * @see PlatypusModel
 * @see Record
 * @see BaseEntity
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface PlatypusInherit {

    Class<? extends BaseModel> value();
}
