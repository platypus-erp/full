package org.platypus.builder.core;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 17/04/17.
 */
public class PluginConf {
    private final String name;
    private final boolean enable = true;
    private final Map<String, Object> option;

    public PluginConf(String name, Map<String, Object> option) {
        this.name = name;
        this.option = option;
    }

    PluginConf(String expr) {
//        display_tree_module_uml(enable::false, opt::opt1:Value)
        String[] e = expr.split("\\(");
        this.name = e[0];
        option = Arrays.stream(e[1].replace(")", "").split(","))
        .map(s -> s.split("::"))
        .collect(Collectors.toMap(t -> t[0], t -> t[1]));

    }

    @Override
    public String toString() {
        return String.format("%s(enable::%s,opt::%s)", name, enable, option.toString());
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getOption() {
        return option;
    }

    public <E extends Enum<E>> E getOptionEnum(String key, Class<E> enumClass, E defaultValue){
        return Enum.valueOf(enumClass, (String)option.getOrDefault(key, defaultValue.name()));
    }

    public void mergeValue(String key, PluginConf conf){
        Object defaultValue = this.option.get(key);
        this.option.put(key, conf.option.getOrDefault(key, defaultValue));
    }

    public int getOptionInt(String key, int defaultValue){
        return (int) option.getOrDefault(key, defaultValue);
    }

    public boolean isEnable() {
        return enable;
    }
}
