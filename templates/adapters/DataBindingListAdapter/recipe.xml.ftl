<?xml version="1.0"?>
<recipe>

<#if generateLayout>
    <instantiate from="root/res/layout/item_simple.xml.ftl"
                 to="${escapeXmlAttribute(resOut)}/layout/${simpleLayoutName}.xml" />
    <open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
</#if>

    <instantiate from="root/src/app_package/adapters/SimpleDataBindingListAdapter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${adapterClass}.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${adapterClass}.java" />
</recipe>
