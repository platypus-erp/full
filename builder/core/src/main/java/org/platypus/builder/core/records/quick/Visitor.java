package org.platypus.builder.core.records.quick;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.printer.PrettyPrintVisitor;
import com.github.javaparser.printer.PrettyPrinterConfiguration;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
public class Visitor extends PrettyPrintVisitor {

    String className;
    String pkg;
    boolean isRootModel;
    String modelName;

    Set<FieldModel> newFields = new HashSet<>();


    public Visitor() {
        super(new PrettyPrinterConfiguration());
    }

    public static Visitor getInfo(CompilationUnit cu){
        Visitor v = new Visitor();
        cu.accept(v, null);
        return v;
    }

    @Override
    public String toString() {
        System.out.println("Visitor{" +
                "className='" + className + '\'' +
                ", pkg='" + pkg + '\'' +
                ", isRootModel=" + isRootModel +
                ", modelName='" + modelName + '\'' +
                ", newFields=" + newFields +
                '}');
        return "";
    }

    @Override
    public void visit(CompilationUnit n, Void arg) {
        super.visit(n, arg);
        System.out.println(super.printer.toString());
    }

    @Override
    public void visit(PackageDeclaration n, Void arg) {
        pkg = n.getName().asString();
        super.visit(n, arg);
    }

    @Override
    public void visit(FieldDeclaration n, Void arg) {
        System.out.println(n.getVariables().get(0).getName().getIdentifier());
        System.out.println(n.getVariables().get(0).getType().toString());
        newFields.add(PlatypusFieldVisitor.getField(n));
        super.visit(n, arg);
    }



    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {
        System.out.println("ClassOrInterfaceDeclaration");
        System.out.println(n.getName().getIdentifier());
        className = n.getName().getIdentifier();
        n.getAnnotationByName("PlatypusModel").ifPresent(a -> {
            isRootModel = true;
            modelName = PlatypusModelAnnotationVisitor.getName(a);
        });
        super.visit(n, arg);
    }
}
