<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap-5.0.2-dist/css/bootstrap.css">
    <link rel="stylesheet" href="css/fontawesome-free-6.4.2-web/css/all.css">
    <style>
        * {
            box-sizing: border-box;
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
        }

        body {
            height: 100vh;
            background-image: url("../images/main_bg.jpg");
            background-size: cover;
            background-position: center center;
            background-repeat: no-repeat;
        }

        .card .card-text {
            font-size: 12px;
        }
    </style>
    <title>Errors</title>
</head>

<body class="d-flex align-items-center justify-content-center">

    <!-- Card: Error Card -->
    <div class="card col-4 alert alert-danger border border-danger text-danger">
        <!-- Card Title -->
        <h3 class="card-title">
            <i class="fa fa-window-close me-2"></i>Errors:
        </h3>
        <!-- End Of Card Title -->
        <hr>
        <!-- Card Body -->
        <div class="card-body">
            <!-- Card Text -->
            <p class="card-text">
            <!-- Display Message -->
            <c:if test="${requestScope.error != null}">
                <div class="alert alert-danger text-center border border-danger">
                    <b>${requestScope.error}</b>
                </div>
            </c:if>
            <!-- End Of Display Message -->
            </p>
            <!-- End Of Card Text -->
            <hr>
            <!-- Back To Login Page -->
            <a href="/login" class="btn btn-sm btn-danger">
                <i class="fa fa-arrow-alt-circle-left me-1"></i> Back
            </a>
            <!-- End Of Back To Login Page -->
        </div>
        <!-- End Of Card Body -->
    </div>
    <!-- End Of Card: Error Card -->
</body>
</html>