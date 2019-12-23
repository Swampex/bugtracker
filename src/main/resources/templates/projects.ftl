<!DOCTYPE html>

<html>

<head>
    <title>Bugtracker: Projects</title>
    <meta http-equiv="content-type">
</head>

<body bgcolor="#ffefd5" background="\triangular.png">

<#include 'fragments/menu.ftl'>

<h2>Bugtracker</h2>

<b>Total number of projects:</b> ${projects?size}
<br>

<h4>Create new project</h4>
<form action="/projects" method="post">
    <label for="name">Name:</label>
    <input id="name" type="text" name="name" value="project_Name">
    <input type="submit" value="Create">
</form>
<hr>
<h3>List of projects</h3>
<#if projects?size != 0>
    <#list projects as project>
        ${project.getName()}<br>
    </#list>
<#else>
    We don't have projects yet.
</#if>

</body>

</html>
