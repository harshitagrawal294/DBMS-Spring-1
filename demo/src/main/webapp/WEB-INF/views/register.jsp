<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<spring:url var="css" value="/css" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Create an account</title>

    <link href="${css}/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${css}/css/bootstrap.css" rel="stylesheet" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css"
    />
  </head>

  <body>
    <div class="jumbotron">
      <div class="container">
        <form:form method="POST" modelAttribute="user" class="form-signin">
          <h2 class="form-signin-heading">Create your account</h2>
          <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
              <form:input
                type="text"
                path="username"
                required="true"
                class="form-control"
                placeholder="Username"
                autofocus="true"
              ></form:input>
              <form:errors path="username"></form:errors>
            </div>
          </spring:bind>

          <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
              <form:input
                type="password"
                path="password"
                required="true"
                class="form-control"
                placeholder="Password"
              ></form:input>
              <form:errors path="password"></form:errors>
            </div>
          </spring:bind>
          <button class="btn btn-lg btn-primary btn-block" type="submit"
            >Submit</button
          >
        </form:form>
      </div>

      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      <script src="${css}/js/bootstrap.min.js"></script>
    </div>
  </body>
</html>