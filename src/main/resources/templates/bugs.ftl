<!DOCTYPE html>
<html>

<head>
    <title>Bugtracker: Bugs</title>
    <link rel="stylesheet" href="\css\styles.css">
</head>

<body bgcolor="#ffefd5" background="\triangular.png">

<div align="left">
    <h2>Bugtracker</h2>
    <#include 'fragments/menu.ftl'> <br>

    <b>Total number of bugs: </b> ${bugs?size}
    <br>

<h4>Create new bug</h4>
<form action="/bugs" method="post">
    <label for="title">Title:
    <input id="title" type="text" name="title" value="titleBub_val">
    </label>
    <label for="description">Description:
    <input id="description" type="text" name="description" value="desc_val">
    </label>
    <label for="project">Project
        <select id="project" name="project_id_name">
            <option selected> </option>
                <#if projects?size !=0>
                    <#list projects as project>
                        <option>${project.getId()} - ${project.getName()}</option>
                    </#list>
                </#if>
            </select>
    </label>
    <input type="submit" value="Report">
</form>

    <h3>List of bugs</h3>

    <div class="divTable blueTable">
        <div class="divTableHeading">
            <div class="divTableRow">
                <div class="divTableHead">ID</div>
                <div class="divTableHead">Title</div>
                <div class="divTableHead">Description</div>
                <div class="divTableHead">Project</div>
            </div>
        </div>
        <div class="divTableBody">
            <#if bugs?size != 0>
                <#list bugs as bug>
                    <div class="divTableRow">
                            <a class="divTableCell" href="/bugs/info?id=${bug.getId()}">${bug.getId()}</a>
                            <div class="divTableCell">${bug.getTitle()}</div>
                            <div class="divTableCell">${bug.getDescription()}</div>
                            <#if (bug.getProject())??>
                            <a class="divTableCell" href="/projects/info?id=${bug.getProject().getId()}">
                            ${bug.getProject().getId()} - ${bug.getProject().getName()}
                            <#else><div class="divTableCell">No project defined</div>
                            </#if>
                            </a>
                    </div>
                </#list>
            </#if>
        </div>
    </div>

<br>
    <br>
</div>
</body>

</html>