<div align="center">
      <h1>Reactive Programming</h1>
Here are some projects under the concept of Reactive Programming. 
</div>

# Tech Used

![Springboot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot) ![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white) ![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white)
      
# Installation

Before You start change below information according to your requirement.

Application.Properties file configurations : 
* Change server port according to you requirements
* Change the username and password for the basic authentication
* Change database name 

Endpoints to access 

*	Step 1 : Insert Admin in database [POST]
	localhost:8080/admin/save
	JSON body to insert Admin 
		{
			"id": 131,
			"username":"demo",
			"password":"123"
		}
	

*	Step 2 : Get List of Admins [GET]
	localhost:8080/admin/all


*	Step 3 : Get Admin by ID [GET]
	localhost:8080/admin/1
	
*	Step 4 : Delete Admin by ID [DELETE]
	localhost:8080/admin/delete/1
	
*	Step 5 : Update Admin in database [PUT]
	localhost:8080/admin/update
	JSON body to insert Admin 
		{
			"id": 131,
			"username":"demo",
			"password":"1234"
		}

After following the above given steps, you are good to go and can run this astonishing project.
    
