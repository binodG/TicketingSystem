<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page session="true"%>
<html>
    <head>
        <title>Login Page</title>
        <style>
            .error {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #a94442;
                background-color: #f2dede;
                border-color: #ebccd1;
            }

            .msg {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #31708f;
                background-color: #d9edf7;
                border-color: #bce8f1;
            }

            #login-box {
                width: 300px;
                padding: 20px;
                margin: 100px auto;
                background: #fff;
                -webkit-border-radius: 2px;
                -moz-border-radius: 2px;
                border: 1px solid #000;
            }
        </style>
        <script src="<c:url value="/resources/js/angular.min.js" />"></script>



    </head>
    <body onload='document.loginForm.username.focus();'>


        <div id="login-box">

            <h3>Login with Username and Password</h3>

            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name="AdminForm" ng-app="adminApp" ng-controller="adminValidate" novalidate action="<c:url value='/check/login' />" method='POST'>

                <table>
                    <tr>
                        <td>User:</td>
                        <td>
                            <input type="text" name="username" ng-model="username" required="required" placeholder="username">
                            <span style="color:red" ng-show="AdminForm.username.$dirty && AdminForm.username.$invalid">
                                <span ng-show="AdminForm.username.$error.required">***</span>
                            </span>
                        
                        </td>
                        
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td>
                            <input type="password" name="password" ng-model="password" required="required" placeholder="Password" />
                                <span style="color:red" ng-show="AdminForm.password.$dirty && AdminForm.password.$invalid">
                                <span ng-show="AdminForm.password.$error.required">***</span>
                            </span>
                        
                        </td>
                        
                    </tr>
                    <tr>
                        <td colspan='2'>
                            <input type="submit" ng-disabled="AdminForm.username.$dirty && AdminForm.username.$invalid || AdminForm.password.$dirty && AdminForm.password.$invalid"
                                   value="submit" />
                        </td>
                    </tr>
                </table>

            </form>
        </div>
        <script>
            var app = angular.module('adminApp', []);
            app.controller('adminValidate', function ($scope) {

            });
        </script>
    </body>
</html>