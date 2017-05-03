<link rel="import" href="../../../bower_components/polymer/polymer.html">
<link rel="import" href="../../components/platypus-data-table/platypus-data-table.html"/>

<dom-module id="platypus-view-${root.target}-list">
    <template>
        <style>
        </style>
        <platypus-data-table target="${root.target}" id="${root.id}">
            <data-table-column id="obj-id" hidden header="id" property="id">
                <template>
                    {{value}}
                </template>
            </data-table-column>
        <#--BOOLEAN COLUMN-->
        <#list root.booleanColumns as column>
            <data-table-column name="${column.headerLabelKey}"  order="${column.order}" filter-by="${column.propertyName}">
                <template>
                    <#if column.toggleDisplayed>
                        <paper-toggle-button disabled="true" checked="[[item.${column.propertyName}]]"></paper-toggle-button>
                    <#else>
                        <paper-checkbox disabled="true" checked="[[item.${column.propertyName}]]"></paper-checkbox>
                    </#if>
                </template>
            </data-table-column>
        </#list>
        <#--DATE TIME COLUMN-->
        <#list root.dateTimeColumns as column>
            <data-table-column name="${column.headerLabelKey}" id="${column.id}" order="${column.order}">
                <template>
                    <toto-date-time date="[[item.${column.propertyName}]]"
                                    display="${column.displayType.value}"></toto-date-time>
                </template>
            </data-table-column>
        </#list>
        <#--TIME COLUMN-->
        <#list root.timeColumns as column>
            <data-table-column name="${column.headerLabelKey}" id="${column.id}" order="${column.order}">
                <template>
                    <toto-time time="[[item.${column.propertyName}]]" second="${column.secondDisplayed}"></toto-time>
                </template>
            </data-table-column>
        </#list>
        <#--DATE COLUMN-->
        <#list root.dateColumns as column>
            <data-table-column name="${column.headerLabelKey}" id="${column.id}" order="${column.order}">
                <template>
                    <toto-date date="[[item.${column.propertyName}]]"
                               mouthDisplay="${column.displayType.value}"></toto-date>
                </template>
            </data-table-column>
        </#list>
        <#--STRING COLUMN-->
        <#list root.stringColumns as column>
            <data-table-column name="${column.headerLabelKey}" id="${column.id}" order="${column.order}"
                               filter-by="${column.propertyName}">
                <template>
                    <toto-label label="[[item.${column.propertyName}]]"></toto-label>
                </template>
            </data-table-column>
        </#list>
        <#--CURRENCY COLUMN-->
        <#list root.currencyColumns as column>
            <data-table-column name="${column.headerLabelKey}" id="${column.id}" order="${column.order}"
                               filter-by="${column.propertyName}">
                <template>
                    <toto-label label="[[item.${column.propertyName}]]"></toto-label>
                </template>
            </data-table-column>
        </#list>
        <#--INTEGER COLUMN-->
        <#list root.integerColumns as column>
            <data-table-column name="${column.headerLabelKey}" id="${column.id}" order="${column.order}"
                               filter-by="${column.propertyName}">
                <template>
                    <toto-label label="[[item.${column.propertyName}]]"></toto-label>
                </template>
            </data-table-column>
        </#list>
        <#--FLOAT COLUMN-->
        <#list root.floatColumns as column>
            <data-table-column name="${column.headerLabelKey}" id="${column.id}" order="${column.order}"
                               filter-by="${column.propertyName}">
                <template>
                    <toto-label label="[[item.${column.propertyName}]]"></toto-label>
                </template>
            </data-table-column>
        </#list>
        <#--IMG COLUMN-->
        <#list root.imgColumns as column>
            <data-table-column name="${column.headerLabelKey}" id="${column.id}" order="${column.order}">
                <template>
                    <#if column.type == "ICON">
                        <iron-icon icon="[[item.${column.propertyName}]]"></iron-icon>
                    <#elseif column.type = "BASE_64">
                        <iron-image src="data:image/png;base64,[[item.${column.propertyName}]]"></iron-image>
                    <#elseif column.type = "LINK">
                        <iron-image src="[[item.${column.propertyName}]]"></iron-image>
                    </#if>
                </template>
            </data-table-column>
        </#list>
        <#--LINK COLUMN-->
        <#list root.linkColumns as column>
            <data-table-column name="${column.headerLabelKey}" id="${column.id}" order="${column.order}">
                <template>
                    <toto-label label="[[item.${column.propertyName}]]"></toto-label>
                </template>
            </data-table-column>
        </#list>
        </platypus-data-table>
    </template>

    <script>

        Polymer({

            is: 'platypus-view-${root.target}-list'

        });

    </script>
</dom-module>
