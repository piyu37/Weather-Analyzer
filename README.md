**Edit a file, create a new file, and clone from GitHUb in under 2 minutes**

## How To Setup DataBase for Weather analyser and Run It
1. Create an empty database with name weatherdata in mysql.
2. GOTO "Data Processor\src\main\resources\hibernate.properties" and change the username and password with your local username and password of mysql.
3. In order to fetch weather data run the AppMain.java file using java
4. Input format for AppMain:-
	a. City name. e.g. "mumbai"
	b. Start date e.g. "2018-06-01"
	c. End date e.g. "2018-06-20"

Note:- Fetching the data is based on API so max no of hits allowed is limited.

##How to Run Weather Analyser
1. Import file "Data Analyser\file\pyspark.ipynb" in Jupiter notebook.
2. Change the IP address of the System where the mysql is installed:-
	a. If environment is local Ip Address would be localhost.
3. Run the program line by line in Jupiter notebook. 
