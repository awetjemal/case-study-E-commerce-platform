<%--
  Created by IntelliJ IDEA.
  User: Awet_Mohammed
  Date: 1/16/2025
  Time: 7:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<jsp:include page="../include/header.jsp"/>

<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <div class="row">
            <h1 class="m-0 text-center">Login</h1>
        </div>
    </div>
</section>


<section class="bg-light2 pt-5 pb-5">
    <div class="container">
        <!-- this will show an error message when the user fails to login -->
        <c:if test="${param.error eq ''}">
            <div class="row justify-content-center">
                <div class="col-6 alert alert-danger" role="alert">
                    Invalid username or password
                </div>
            </div>
        </c:if>

        <!-- this form has to submit to the .loginProcessingUrl we configured in the spring security config -->
        <!-- and it must be a method=post -->
        <!-- name of the input field MUST BE username -->
        <!-- name of the password fields MUST BE password -->
        <form action="/login/loginSubmit" method="post">
            <div class="mt-3 row justify-content-center">
                <label for="username" class="col-sm-2 col-form-label">Username</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="username" name="username" value="">
                </div>
            </div>

            <div class="mt-3 row justify-content-center">
                <label for="password" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="password" class="form-control" id="password" name="password" value="">
                </div>
            </div>

            <div class="mt-3 row justify-content-center">
                <div class="col-sm-12 col-lg-8">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
