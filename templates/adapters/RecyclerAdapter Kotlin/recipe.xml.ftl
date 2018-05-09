<?xml version="1.0"?>
<recipe>

<#if generateLayout>
    <#include "../common/recipe_simple.xml.ftl" />
    <open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
</#if>

    <instantiate from="root/src/app_package/adapters/SimpleRecyclerAdapter.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${adapterClass}.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${adapterClass}.kt" />
</recipe>
