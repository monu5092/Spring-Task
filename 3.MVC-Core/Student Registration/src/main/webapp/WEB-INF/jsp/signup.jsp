<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
 <h1>Sign up Page</h1>
 <form:form action="registerUser" modelAttribute="user">
 name:
 <form:input path="name"/>
 <br/>
 <br/>
 Gender:
 <br/>
 Male<form:radiobutton path="gender" value="male"/>
 Female<form:radiobutton path="gender" value="female"/>
 <br/>
 <br/>
 Location:
 <form:select path="location">
 	<form:option value="India"></form:option>
 	<form:option value="NRI"></form:option>
 </form:select>
 <br/>
 <br/>
 College
  <form:select path="college">
 	<form:option value="test123"></form:option>
 	<form:option value="testCollege"></form:option>
 </form:select>
 <input type="submit">
 </form:form>
</html>