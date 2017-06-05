package base.test;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

/**
 * @author chmuchme
 * @since 0.1
 * on 03/06/17.
 */
public class Main2 {

    public static void main(String[] args) {
        CompilationUnit cu = JavaParser.parse(Main2.class.getResourceAsStream("test.java"));
        MyVisitor v = new MyVisitor();
        cu.accept(v, null);

        System.out.println(v.imports);
    }
}
