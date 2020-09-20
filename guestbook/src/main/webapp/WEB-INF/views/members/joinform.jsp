<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
  <html>
    <head>
      <title>회원가입 </title>
    </head>
  <body>
    <div>
      <div>
        <form method="post" action="/connect/members/join">
          <div>
            <label>ID</label>
            <input type="text" name="userId">
          </div>
          <div>
            <label>암호</label>
            <input type="password" name="password">
          </div>
          <div>
            <label></label>
            <input type="submit" value="회원가입">
          </div>
        </form>
      </div>
    </div>
  </body>
</html>