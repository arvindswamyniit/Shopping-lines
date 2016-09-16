<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="addTheProduct" commandName="pro" method="post">
Name:<form:input path="name"/>
Brand:<form:input path="brand"/>
Price:<form:input path="price"/>
<input type="submit" value="submit"/>
</form:form>
