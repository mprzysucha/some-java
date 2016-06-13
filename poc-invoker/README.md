poc-invoker
===========




------------------------------------------------------

First console:

1. git clone https://github.com/mprzysucha/poc-invoker
2. cd poc-invoker/ShopModel
3. mvn clean install
4. cd ../ShopService
5. mvn clean install
6. mvn jetty:run

------------------------------------------------------

Second console:

1. cd poc-invoker/ShopClient
2. mvn clean install
3. mvn exec:exec

------------------------------------------------------
