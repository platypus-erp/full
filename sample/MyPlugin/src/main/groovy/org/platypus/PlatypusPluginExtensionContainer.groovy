package org.platypus

/**
 * @author chmuchme
 * @since 0.1
 * on 21/04/17.
 */
class PlatypusPluginExtensionContainer {
    final String name
    boolean enable = true
    Map<String, String> opt = new HashMap<>()


    PlatypusPluginExtensionContainer(String name) {
        this.name = name
    }

    @Override
    String toString() {
        return "$name(enable::$enable - opt::$opt)"
    }
}
