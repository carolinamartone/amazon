<!DOCTYPE html>
<html lang="en">

<head th:fragment="head(page_title)" lang="en">
    <meta charset="UTF-8"/>
    <meta description="viewport" content="width=device-width, initial-scale=1"/>

    <link rel="icon" th:href="@{/images.png}" />

    <link rel="stylesheet" th:href="@{/vendor/materialize/css/materialize.css}" />
    <link rel="stylesheet" th:href="@{/vendor/codrops/css/cs-select.css}" />
    <link rel="stylesheet" th:href="@{/vendor/codrops/css/cs-skin-border.css}" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" th:href="@{/app.css}" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
	
    <title th:text="'Amazon | ' + ${page_title}">Amazon</title>
</head>

<body>

<div th:fragment="nav" class="navbar-fixed">
    <nav>
        <div class="container">
            <div class="brand-logo" th:text="${heading}"></div>
            <a href="#" data-activates="mobile-nav" class="button-collapse right"><i class="material-icons">menu</i></a>
            <ul class="right hide-on-med-and-down">
                <li ><a th:href="@{/index}">AllCategories</a></li>
                <
                
            </ul>
        </div>
    </nav>
</div>


<div th:fragment="scripts">
    <script th:src="@{/vendor/jquery/jquery-1.11.3.js}"></script>
    <script th:src="@{/vendor/materialize/js/materialize.js}"></script>
    <script th:src="@{/vendor/codrops/js/classie.js}"></script>
    <script th:src="@{/vendor/codrops/js/selectFx.js}"></script>
    <script th:src="@{/app.js}"></script>
</div>

</body>
</html>