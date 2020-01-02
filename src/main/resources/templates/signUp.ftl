<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Registration form
    </div>
    <form method="post" action="/signUp">
        <label for="name">Name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <label for="login">Login
            <input class="input-field" type="text" id="login" name="login">
        </label>
        <br>
        <label for="password">Password
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <br>
        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">Remember me</label>
        <input type="submit" value="Sign Up">
    </form>
</div>
</body>
</html>