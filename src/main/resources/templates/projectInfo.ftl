<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">

<head>
    <title>Bugtracker: Bugs</title>
    <link rel="stylesheet" href="\css\styles.css">
</head>

<body bgcolor="#ffefd5" background="\triangular.png">

<h2>Bugtracker</h2>
<#include 'fragments/menu.ftl'> <br>

<h3>Edit project</h3>
<form action="/projects/update?id=${project.getId()}" method="post">
    <label for="id">ID
        <input id="id" type="text" name="project_id" readonly value="${project.getId()}">
    </label>
    <label for="projectName">Project name
        <input id="projectName" type="text" name="project_name" value="${project.getName()}">
    </label>
    <input type="submit" value="Update">
</form>

<form action="/projects/delete" method="get">
    <input type="hidden" name="id" value="${project.getId()}">
    <input type="submit" value="delete">
</form>


<h3>List of bugs</h3>

<div class="divTable blueTable">
    <div class="divTableHeading">
        <div class="divTableRow">
            <div class="divTableHead">ID</div>
            <div class="divTableHead">Title</div>
            <div class="divTableHead">Description</div>
        </div>
    </div>
    <div class="divTableBody">
        <#if bugs?size != 0>
            <#list bugs as bug>
                <div class="divTableRow">
                    <a class="divTableCell" href="/bugs/info?id=${bug.getId()}">${bug.getId()}</a>
                    <div class="divTableCell">${bug.getTitle()}</div>
                    <div class="divTableCell">${bug.getDescription()}</div>
                </div>
            </#list>
        </#if>
    </div>
</div>

<br>

</body>

</html>