<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

	<head>
		<title>Student Registration Form</title>
	</head>
	
	<body>
		
		<form:form action = "processForm" modelAttribute="student">
		
			First Name: <form:input path = "firstName" />
			
			<br><br>
			
			Last Name: <form:input path = "lastName" />
			
			<br><br>
			
			<form:select path = "country">
				
				<form:options items="${ theCountryOptions }" />
				
			</form:select>
			
			<br><br>
			
			Favorite Language: 
			
			Java <form:radiobutton path = "favoriteLanguage" value = "Java" />
			C# <form:radiobutton path = "favoriteLanguage" value = "C#" />
			Ruby <form:radiobutton path = "favoriteLanguage" value = "Ruby" />
			PHP <form:radiobutton path = "favoriteLanguage" value = "PHP" />
			
			<br><br>
			
			Operating Systems:
			
			Linux <form:checkbox path = "operatingSystems" value = "Linux" />
			Mac OS <form:checkbox path = "operatingSystems" value = "Mac OS" />
			MS Windows <form:checkbox path = "operatingSystems" value = "MS Windows" />
			
			<br><br>
			
			<input type = "submit" value = "Submit" />
		
		</form:form>
		
	</body>

</html>