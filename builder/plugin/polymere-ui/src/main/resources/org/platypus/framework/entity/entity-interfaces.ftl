<#-- @ftlvariable name="root" type="org.platypus.framework.data.PlatypusBO" -->
package ${root.packageName};

public interface Generated${root.className} implements <#list root.interfaces in interface>
                                                        ${interface.fqn}<#sep >,</#list>{


}