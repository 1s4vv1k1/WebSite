<#import "parts/common.ftlh" as c>
<#import "parts/loginPage.ftlh" as l>

<@c.page>
    Add new user
    ${message?ifExists}
    <@l.login "/registration" />
</@c.page>