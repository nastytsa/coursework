<#import "parts/common.ftlh" as c>

<@c.page>
    User editor
    <form action="/user" method="post">
        <input type="text" name="username" value="${user.username}">
        <#list roles as role>
            <div>
                <label>
                    <input type="checkbox" name="${role}">${role}
                </label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" style="background-color: lightgoldenrodyellow">Save</button>
    </form>
</@c.page>