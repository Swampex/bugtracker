<#ftl encoding='UTF-8'>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<form action="/profileSettings?id=${user.getId()}" method="post">
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
    <input type="submit" value="Edit profile">
</form>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>