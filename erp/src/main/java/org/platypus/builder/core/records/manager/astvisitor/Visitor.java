package org.platypus.builder.core.records.manager.astvisitor;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.platypus.api.annotations.field.BigStringFieldDefinition;
import org.platypus.api.annotations.field.BinaryFieldDefinition;
import org.platypus.api.annotations.field.BooleanFieldDefinition;
import org.platypus.api.annotations.field.DateFieldDefinition;
import org.platypus.api.annotations.field.DateTimeFieldDefinition;
import org.platypus.api.annotations.field.DecimalFieldDefinition;
import org.platypus.api.annotations.field.FloatFieldDefinition;
import org.platypus.api.annotations.field.IntFieldDefinition;
import org.platypus.api.annotations.field.LongFieldDefinition;
import org.platypus.api.annotations.field.ManyToManyFieldDefinition;
import org.platypus.api.annotations.field.ManyToOneFieldDefinition;
import org.platypus.api.annotations.field.OneToManyFieldDefinition;
import org.platypus.api.annotations.field.OneToOneFieldDefinition;
import org.platypus.api.annotations.field.StringFieldDefinition;
import org.platypus.api.annotations.field.TimeFieldDefinition;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
public class Visitor extends VoidVisitorAdapter<Void> implements AstModel{

    String className;
    String pkg;
    boolean isRootModel;
    boolean isValidModel;
    String modelName;

    Map<String, Set<FieldModel>> fields = new HashMap<>();

    @Override
    public Set<FieldModel> getBigStringField() {
        return getFields(BigStringFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getBinaryField() {
        return getFields(BinaryFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getBooleanField() {
        return getFields(BooleanFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getDateField() {
        return getFields(DateFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getDateTimeField() {
        return getFields(DateTimeFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getDecimalField() {
        return getFields(DecimalFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getFloatField() {
        return getFields(FloatFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getIntField() {
        return getFields(IntFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getLongField() {
        return getFields(LongFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getStringField() {
        return getFields(StringFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getTimeField() {
        return getFields(TimeFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getOtoField() {
        return getFields(OneToOneFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getOtmField() {
        return getFields(OneToManyFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getMtmField() {
        return getFields(ManyToManyFieldDefinition.class);
    }

    @Override
    public Set<FieldModel> getMtoField() {
        return getFields(ManyToOneFieldDefinition.class);
    }

    private Set<FieldModel> getFields(Class<? extends Annotation> annotation){
        return fields.getOrDefault(annotation.getSimpleName(), Collections.emptySet());
    }

    public String getClassName() {
        return className;
    }

    public String getPkg() {
        return pkg;
    }

    public boolean isRootModel() {
        return isRootModel;
    }

    public String getModelName() {
        return modelName;
    }

    public Visitor() {
    }

    public static Visitor getInfo(CompilationUnit cu) {
        Visitor v = new Visitor();
        cu.accept(v, null);
        return v;
    }

    @Override
    public String toString() {
        System.out.println("ServiceVisitor{" +
                "\nclassName='" + className + '\'' +
                ",\npkg='" + pkg + '\'' +
                ",\nisRootModel=" + isRootModel +
                ",\nmodelName='" + modelName + '\'' +
                ",\nisValidModel=" + isValidModel +
                ",\norg.platypus.api.fields=" + fields +
                '}');
        return "";
    }

    @Override
    public void visit(CompilationUnit n, Void arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(PackageDeclaration n, Void arg) {
        pkg = n.getName().asString();
        super.visit(n, arg);
    }

    @Override
    public void visit(FieldDeclaration n, Void arg) {
        FieldModel fieldModel = PlatypusFieldVisitor.getField(n);
        Set<FieldModel> sets = fields.getOrDefault(fieldModel.annotatedWithName, new HashSet<>());
        sets.add(fieldModel);
        fields.put(fieldModel.annotatedWithName, sets);
        super.visit(n, arg);
    }


    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {
        className = n.getName().getIdentifier();
        if (n.getAnnotationByName("PlatypusModel").isPresent()
                || n.getAnnotationByName("PlatypusModelInherit").isPresent()) {
            n.getAnnotationByName("PlatypusModel").ifPresent(a -> {
                isValidModel = !n.getAnnotationByName("PlatypusModelInherit").isPresent();
                isRootModel = true;
                modelName = PlatypusModelAnnotationVisitor.getName(a);
            });
            n.getAnnotationByName("PlatypusModelInherit").ifPresent(a -> {
                isValidModel = true;
                isRootModel = false;
                modelName = PlatypusModelAnnotationVisitor.getName(a);
            });
        } else {
            isValidModel = false;
        }
        super.visit(n, arg);
    }

    public boolean isValidModel() {
        return isValidModel;
    }
}
