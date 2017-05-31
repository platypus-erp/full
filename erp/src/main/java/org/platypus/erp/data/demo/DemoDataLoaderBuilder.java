package org.platypus.erp.data.demo;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.platypus.api.Record;

import java.io.InputStream;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class DemoDataLoaderBuilder {
    private InputStream datas;
    private JavaType dataType;
    private String fileName;


    private DemoDataLoaderBuilder(InputStream datas) {
        this.datas = requireNonNull(datas, "the inputStream can't be null");
    }

    public static DemoDataLoaderBuilder fromStream(InputStream stream) {
        return new DemoDataLoaderBuilder(stream);
    }

    public static DemoDataLoaderBuilder createStream(Class<?> clazz, String clazzRelativePathFile) {
        DemoDataLoaderBuilder builder = new DemoDataLoaderBuilder(requireNonNull(clazz, "the class can't be null").getResourceAsStream(clazzRelativePathFile));
        builder.fileName = requireNonNull(clazzRelativePathFile);
        return builder;
    }

    public DemoDataLoaderBuilder convertToEntity(Class<? extends Record> entity) {
        this.dataType = TypeFactory.defaultInstance().constructType(requireNonNull(entity, "the class entity can't be null"));
        return this;
    }

    public DemoDataLoaderBuilder convertToCollectionOfEntity(Class<? extends Record> entity) {
        this.dataType = TypeFactory.defaultInstance().constructCollectionType(List.class, requireNonNull(entity, "the class entity can't be null"));
        return this;
    }

    public InputStream getDatas() {
        return datas;
    }

    public JavaType getDataType() {
        return dataType;
    }
}
