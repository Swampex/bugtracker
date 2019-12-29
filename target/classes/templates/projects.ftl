<!DOCTYPE html>

<html>

<head>
    <title>Bugtracker: Projects</title>
    <meta http-equiv="content-type">
    <link rel="stylesheet" href="\css\styles.css">
</head>

<body bgcolor="#ffefd5" background="\triangular.png">

<h2>Bugtracker</h2>
<#include 'fragments/menu.ftl'>

<b>Total number of projects:</b> ${projects?size}
<br>

<h4>Create new project</h4>
<form action="/projects" method="post">
    <label for="name">Name:</label>
    <input id="name" type="text" name="name" value="project_Name">
    <input type="submit" value="Create">
</form>

<h3>List of projects</h3>

<div class="divTable blueTable">
    <div class="divTableHeading">
        <div class="divTableRow">
            <div class="divTableHead">ID</div>
            <div class="divTableHead">Project Name</div>
        </div>
    </div>
    <div class="divTableBody">
        <#if projects?size != 0>
            <#list projects as project>
                <div class="divTableRow">
                    <a class="divTableCell" href="/projects/info?id=${project.getId()}">${project.getId()}</a>
                    <div class="divTableCell">${project.getName()}</div>
                </div>
            </#list>
        <#else>
            We don't have projects yet.
        </#if>
    </div>
</div>

<br>
<br>
</body>

</html>
