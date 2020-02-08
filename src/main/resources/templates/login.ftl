<#ftl encoding='UTF-8'>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Bugtracker: Sign in</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="\css\styles_checkbox.css">
</head>
<body>
<div class="container-fluid">
    <#include 'fragments/navbar_preLogin.ftl'>
    <div class="row">
        <div class="col-md-2" style="background-color: #AAAAAA">

        </div>
        <div class="col-md-10" style="background-color: #8F8F8F">
            <#if error??>
                <div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
            </#if>
            <div class="form-style-2">
                <div class="h4 mb4">
                    Sign in
                </div>
                <form method="post" action="/login">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="login">Login</label>
                            <input class="form-control" type="text" id="login" name="login">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="password">Password</label>
                            <input class="form-control" type="password" id="password" name="password">
                        </div>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="defaultUnchecked" name="remember-me">
                        <label class="custom-control-label" for="defaultUnchecked">Remember me</label>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Log in">
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>