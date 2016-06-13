rest-sample
===========

------------------------------------------------------

1. git clone https://github.com/mprzysucha/rest-sample
2. mvn clean jetty:run

------------------------------------------------------

REST client:

PUT http://localhost:8080/rest/cars/gear

{"shaft" : "new shaft",
"gearbox" : "new gearbox",
"clutch" : "new clutch"}

PATCH http://localhost:8080/rest/cars/gear

{"clutch" : "new clutch"}
