<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Razor sight</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>

<body>
    <nav class="navbar navbar-expand-sm bg-light">
        <span class="navbar-brand mx-auto">
            Razor sight
        </span>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">
                        <%
                        HttpSession session = request.getSession(false);
                        if(null	!= session.getAttribute("username"))
                            {
                                out.println(session.getAttribute("username"));
                            }
                        %>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="displayimage">Display Image</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout">Logout</a>
            </li>
        </ul>
    </nav>
    <br>
</body>

</html>