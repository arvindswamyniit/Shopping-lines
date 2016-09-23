<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="addTheProduct" commandName="pro" method="post" enctype="multipart/form-data">
Name:<form:input path="name"/>
Brand:<form:input path="brand"/>
Price:<form:input path="price"/>
Add Product Image:<input type="file" name="file"/>
<input type="submit" value="submit"/>
</form:form>
