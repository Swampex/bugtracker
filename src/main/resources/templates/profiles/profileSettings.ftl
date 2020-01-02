<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<form action="/profileSettings?id=${user.getLogin()}" method="post">
    <fieldset>
        <label>
            Login
            <input type="text" name="login" value="${user.getLogin()}">
        </label>
        <label>
            First name
            <input type="text" name="firstName" value="${user.getFirstName()}">
        </label>
        <label>
            Last name
            <input type="text" name="lastName" value="${user.getLastName()}">
        </label>
        <label>User roles</label>
        <div class="userSettings">
            <#list userRolesStates as role, state>
                <div class="checkBox_row">
                    <div>
                        <label for=${role}>${role}</label>
                    </div>
                    <div>
                        <input id=${role} type="checkbox" name=${"role_"+role} <#if state>checked</#if>>
                    </div>
                </div>
            </#list>
        </div>

    </fieldset>
    <input type="submit" value="Report">
</form>

</body>
</html>