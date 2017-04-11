package org.platypus.sample.depends;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/03/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Main.class.getResourceAsStream("/org/platypus/sample/depends/local_fr_FR.properties") == null);
        System.out.println(Main.class.getResourceAsStream("local_fr_FR.properties") == null);
        System.out.println(Main.class.getResourceAsStream("views/form/local_fr_FR.properties") == null);
    }
}
