# weatherTopFinal
Student Name: Deirdre Belton
Student Number: 20100053

WeatherTop Release 2 has been achieved, except for the deployment of the app. The user has the ability to sign up, log in, add stations and readings, delete stations
and readings and see the latest reading weather metrics. 

Note, the temporary files from the project folder have been deleted before upload to Github repository, therefore, Play Idealize command must 
be used before opening the project in Play.  

Known issue: When you create a station and try to open the folder to the new station, there is an error. It is because my index method in station ctrl 
is expecting readings associated with a station, but a new station will not have any readings yet. I tried to implement an IF statement to say if 
station.readings != null, execute the code associated with the latest reading and weather conditions, ELSE just load stations.html, but I had no luck with this, unfortunately. 

References used to help with project: 
https://www.geeksforgeeks.org/java-program-to-calculate-power-of-a-number/
https://www.javatpoint.com/java-string-to-double
https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
https://semantic-ui.com/collections/grid.html#colored
https://semantic-ui.com/collections/grid.html#device-visibility
https://fomantic-ui.com/introduction/getting-started.html#using-a-cdn-provider
https://fomantic-ui.com/elements/icon.html#maps
