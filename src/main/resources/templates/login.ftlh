<#import "parts/common.ftlh" as c>
<#import "parts/loginPage.ftlh" as l>

<@c.page>
    ${message?ifExists}
    <@l.login "/login" false/>
</@c.page>