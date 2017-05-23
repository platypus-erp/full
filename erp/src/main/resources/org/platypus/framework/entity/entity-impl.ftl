<#-- @ftlvariable name="root" type="org.platypus.framework.data.PlatypusBO" -->
package ${root.packageName};

@javax.persistence.Entity
@javax.persistence.Table(name= ${root.target})
public interface Generated${root.className}Impl implements Generated${root.className}{
<#--TODO serializable-->
<#list root.fields>
    <#items as field>
    @javax.persistence.Column(name=${field.colName}
        <#if field.colDef??>, columnDefinition="${field.colDef}"</#if>
        <#if !field.insertable>, insertable=false</#if>
        <#if !field.updatable>, updatable=false</#if>
        )
    private ${field.fieldType} ${field.name}<#if field.defaultValue??><#switch field.defaultValue><#case ""</#switch></#if>;

    </#items>
</#list>
}