[#-- @ftlvariable name="root" type="org.platypus.framework.maven.views.list.ListView" --]
{
"defaultFilterId":"${root.defaultFilterId}",
"pageSize":"${root.dataTableView.pageSize.value}",
<#list root.dataTableView.allColumns>
"columns":[
    <#items as col>
    {
    "id":"${col.id}",
    "hidden":${col.actif?c},
<#if col.columnType = "RELATION">
    "relation":true,
    "property":"${col.propertyName}.${col.subProperty}"
<#else>
    "relation":false,
    "property":"${col.propertyName}"
</#if>
    }<#sep >,
    </#items>
]
</#list>
}