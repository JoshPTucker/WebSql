<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
 <form action="SqlEntry" method="post">
<fieldset>
<textarea rows="4" cols="30" id="query" name="query" placeholder="SQl>>"></textarea>
</fieldset> 
 <fieldset>
 <input type="submit" id="submit" value="submit" name="submit"  />
 </fieldset>
 </form>
</div>





</body>
</html>