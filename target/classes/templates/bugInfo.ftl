<!DOCTYPE html>
<html>

<head>
    <title>Bugtracker: Bugs</title>
    <link rel="stylesheet" href="\css\styles.css">
</head>

<body bgcolor="#ffefd5" background="\triangular.png">

<#include 'fragments/menu.ftl'> <br>

<h2>Bugtracker</h2>

<h3>Edit bug</h3>
<form action="/bugs/update?id=${bug.getId()}" method="post">
    <label for="id">ID
        <input id="id" type="text" name="bug_id" readonly autocomplete="off" value="${bug.getId()}">
    </label>
    <label for="title">Title
        <input id="title" type="text" name="title" value="${bug.getTitle()}">
    </label>
    <label for="description">Description
        <input id="description" type="text" name="description" autocomplete="off" value="${bug.getDescription()}">
    </label>
    <label for="project_id_name">Project
        <select id="project_id_name" name="project_id_name">
            <#if bug.getProject()??><option selected> ${bug.getProject().getId()} - ${bug.getProject().getName()} </option>
            <#else> <option selected> </option>
            </#if>
            <#list projects as project>
                <option>${project.getId()} - ${project.getName()}</option>
            </#list>
        </select>
    </label>
    <input type="submit" value="Update">
</form>

<form action="/bugs/delete" method="get">
    <input type="hidden" name="id" value="${bug.getId()}">
    <input type="submit" value="delete">
</form>

<br>

</body>

</html>