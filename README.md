Toy application to test a web application server (e.g., Tomcat) and see what
data is available with an HttpServletRequest object.

Deploy
======

From the project home directory:

    mvn package
    cp target/helloworldservlet.war ${CATALINA_HOME}/webapps/

Use
===

Assumption: your web app server is listening on port 8080.

To check the web app was correctly deployed, go to [http://localhost:8080/helloworldservlet/index.jsp]().

To see the cookies and headers received by the web app, go to [http://localhost:8080/helloworldservlet/RequestDump/]().
