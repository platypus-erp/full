package org.platypus.api.annotations.model;

import org.platypus.api.BaseModel;
import org.platypus.api.Record;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to define a new model
 * <br/>
 * The value will be the table methodName following the SQL format
 * <br/>
 * <b>This annotation can only be apply above a java public class</b>
 * <br/>
 * <b>All the class annotated with @PlatypusModel should implment the interface {@linkplain BaseModel}</b>
 * <br/>
 *
 * The platypus framework generate 2 inteface from your model.<br/>
 * The first one is a {@linkplain Record Record}.<br/>
 * The second is a {@linkplain BaseModel Entity}.<br/>
 * 99% of the time when you use the platypus framework only the generated
 * {@linkplain Record Record} is useful
 * The generated {@linkplain BaseModel Entity}
 * is used internally but maybe the platypus framework offer not enought feature and you need to use the lower API.
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 *
 * @see Record
 * @see BaseModel
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PlatypusModel {
    /**
     * Define the table methodName of the generated entity
     * <br/>
     * The value can only accept <bold>letter</bold> or dot <bold>.</bold><br>
     * The value is not case sensitive, all the dot will be replace by "_"
     * <pre>
     *  myTable ==> MYTABLE
     *  mytable ==> MYTABLE
     *  my.table ==> MY_TABLE
     * </pre>
     */
    String value();


}
