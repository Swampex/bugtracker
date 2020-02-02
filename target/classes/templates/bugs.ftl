<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Bugtracker: Bugs</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="\css\styles.css">
</head>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2" style="background-color: #AAAAAA">
            <#include 'fragments/menu.ftl'> <br>
        </div>
        <div class="col-md-10" style="background-color: #8F8F8F">
            <b>Total number of bugs: ${bugs?size} </b>
            <br>
            <h4>Create new bug</h4>

            <br><br>

            <form role="form" action="/bugs" method="post">

                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" id="title" name="title" value="" class="form-control">
                    <label for="description">Description</label>
                    <textarea id="description" name="description" class="form-control"></textarea>
                    <label for="project">Project</label>
                    <select class="form-control" id="project" name="project_id">
                        <option selected></option>
                        <#if projects?size !=0>
                            <#list projects as project>
                                <option value="${project.getId()}">${project.getId()} - ${project.getName()}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
                <input type="submit" class="btn btn-primary" value="Report">
            </form>

            <br><br>

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
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>

</html>