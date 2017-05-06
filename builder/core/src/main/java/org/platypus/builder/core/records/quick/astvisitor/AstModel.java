package org.platypus.builder.core.records.quick.astvisitor;

import org.platypus.api.Namable;

import java.util.Map;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 06/05/17.
 */
public interface AstModel {
    Set<FieldModel> getBigStringField();
    Set<FieldModel> getBinaryField();
    Set<FieldModel> getBooleanField();
    Set<FieldModel> getDateField();
    Set<FieldModel> getDateTimeField();
    Set<FieldModel> getDecimalField();
    Set<FieldModel> getFloatField();
    Set<FieldModel> getIntField();
    Set<FieldModel> getLongField();
    Set<FieldModel> getStringField();
    Set<FieldModel> getTimeField();

    Set<FieldModel> getOtoField();
    Set<FieldModel> getOtmField();
    Set<FieldModel> getMtmField();
    Set<FieldModel> getMtoField();

    String getClassName();
    boolean isRootModel();
    String getModelName();
    String getPkg();
    boolean isValidModel();
}
