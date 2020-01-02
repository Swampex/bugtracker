<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="form-style-2-heading">Имя: ${user.getFirstName()}</div>
    <div class="form-style-2-heading">Дата рождения: ${user.getLogin()}</div>
    <a href="/logout">Exit</a>
</body>
</html>