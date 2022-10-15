<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Signup</title>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
        * {
            box-sizing: border-box;
            padding: 0;
            margin: 0;
            font-family: 'Lato', sans-serif;
        }

        body {
            background-color: #1d84e4;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        p {
            padding-top: 20px;
            color: #5f5d5d;
        }

        .login-link {
            text-align: center;
            color: #5f5d5d;
        }

        header {
            padding-bottom: 20px;
        }

        .container {
            background-color: #ffffff;
            max-width: 50%;
            width: 600px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
            padding: 20px;
            border-radius: 10px 0 10px 0;
            box-shadow: #272424;
            padding-bottom: 20px;
        }

        .form-control {
            margin-top: 10px;
            padding-bottom: 20px;
            position: relative;
        }

        .firstName,
        .lastName {
            width: 100%;
            padding: 13px;
            border: 1px solid #f3efef;
            background-color: #f3efef;
            border-radius: 5px;
        }

        .firstNameDiv,
        .lastNameDiv {
            display: inline-block;
            min-width: 100%;
        }

        .firstNameDiv {
            margin-top: 20px;
        }

        .email,
        .password,
        .confirmPassword {
            width: 100%;
            padding: 13px;
            border: 1px solid #f3efef;
            background-color: #f3efef;
            border-radius: 5px;
        }

        .form-control.success input {
            border: 2px solid#2ecc71;
        }

        .form-control.error input {
            border: 2px solid #e74c3c;
        }

        .form-control.error small {
            color: #e74c3c;
            visibility: visible;
        }

        .form-control small {
            position: absolute;
            bottom: 0;
            left: 0;
            visibility: hidden;
        }

        .checkbox {
            margin-top: 20px;
        }

        i {
            visibility: hidden;
        }

        label {
            color: #5f5d5d;
        }

        span {
            color: #0f82ee;
        }

        .button {
            display: block;
            margin-top: 20px;
            background-color: #1d84e4;
            color: #ffffff;
            padding: 10px 30px;
            border: 1px solid #1d84e4;
            border-radius: 5px;
            font-weight: bold;
            font-size: 17px;
        }
    </style>
</head>
<body>
<main class="container">
    <header>
        <h1>Welcome</h1>
        <p style="font-size: 1.2rem">Please fill in this form to create an account!</p>
    </header>
    <form  method="post" id="form">
        <div class="form-control firstNameDiv">
            <input
                    type="text"
                    placeholder="First Name"
                    class="firstName"
                    id="firstName"
                    name="firstname"
            />
            <small>Error message</small>
        </div>
        <div class="form-control lastNameDiv">
            <input
                    type="text"
                    placeholder="Last Name"
                    class="lastName"
                    id="lastName"
                    name="lastname"
            />
            <small>Error message</small>
        </div>
        <div class="form-control firstNameDiv">
            <input
                    type="text"
                    placeholder="Age"
                    class="firstName"
                    id="firstName"
                    name="age"
            />
        </div>
        <div class="form-control">
            <input type="email" placeholder="Email" class="email" id="email" />
            <small>Error message</small>
        </div>
        <div class="form-control">
            <input
                    type="password"
                    placeholder="Password"
                    class="password"
                    id="password"
                    name="password"
            />
            <small>Error message</small>
        </div>
        <div class="form-control">
            <input
                    type="password"
                    placeholder="Confirm Password"
                    class="confirmPassword"
                    id="confirmPassword"
                    name="conf-password"
            />
            <small>Error message</small>
        </div>
        <div class="form-control firstNameDiv">
            <input
                    type="text"
                    placeholder="Picture URL"
                    class="firstName"
                    id="firstName"
                    name="pictureUrl"
            />
            <small>Error message</small>
        </div>
        <button type="submit" class="button" id="signUp">
            Sign Up <i class="fa fa-spinner fa-spin"></i>
        </button>
    </form>
    <p class="login-link">
        Already have an account? <a href="login.ftl">Login here</a>
    </p>
</main>
</body>
<script src="registration.js"></script>
</html>
