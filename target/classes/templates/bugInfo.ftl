<!DOCTYPE html>
<html>

<head>
    <title>Bugtracker: Bugs</title>
    <link rel="stylesheet" href="\css\styles.css">
</head>

<body bgcolor="#ffefd5" background="\triangular.png">

<h2>Bugtracker</h2>
<#include 'fragments/menu.ftl'> <br>

<h4>${bug.getId()} - ${bug.getTitle()}</h4>
<form action="/bugs/update?id=${bug.getId()}" method="post">
    <input type="hidden" id="bug_id" name="bug_id" value="${bug.getId()}">
    <label>
        Title
        <input type="text" name="title" value="${bug.getTitle()}">
    </label>
    <label>
        Description
        <textarea name="description">${bug.getDescription()}</textarea>
    </label>
    <label for="project_id_name">Project
        <select id="project_id_name" name="project_id_name">
            <#if bug.getProject()??><option selected value="${bug.getProject().getId()}"> ${bug.getProject().getId()} - ${bug.getProject().getName()} </option>
            <#else> <option selected> </option>
            </#if>
            <#list projects as project>
                <option value="${project.getId()}">${project.getId()} - ${project.getName()}</option>
            </#list>
        </select>
    </label> <br>
    <input class="button" type="submit" value="Update">
</form>
<br>
<form action="/bugs/delete" method="get">
    <input type="hidden" name="id" value="${bug.getId()}">
    <button value="Delete" type="submit"><img src="https://image.flaticon.com/icons/png/512/2290/premium/2290700.png" height="40"></button>
</form>

<br>

</body>

</html>