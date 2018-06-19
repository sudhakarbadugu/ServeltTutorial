package com.conduent.servlet;

public class ServletDef {
	// java can be used to develop standlone application
	// jee can be used to develop enterprise application
	// servlet can be used to develop web application
	// servlet api consist set of classes and interfaces
	// web application is nothing but a folder or war file(web archive).
	// it having two packages
	// javax.servlet --- can be used for any protocol
	// javax.servlet.http --- can be used for http protocols only.
	// servlet can be run on server side
	// servers like apache tomcat,JBOSS,glasfish etc
	// apache tomcat is easy to use and maintain
	// it will start easyily and stoping also easy
	// for changing port number its easy
	// http is a protocol send the request and get response
	// https :send the request and get response and its secure
	// for every http requset from client server will send a http response
	// for our request if the information is there in server will get response or
	// will get error response
	// static response and dynamic response
	// static response means content is same always for any no.of requests.
	// dynamic response means content will change always for any no.of requests.

	// before servlet we have cgi to develop web appln but it having some
	// limitations
	// cgi is a process based means for every request cgi will create a separate cgi
	// shell
	// so it will take more time to send response
	// it will take more memory
	// it is platform dependent
	// sun people introduced servlet to develop web appln
	// it is thread based.for every request it creates a thread.all threads shares a
	// common memory area.
	// response time is less and secure

	// if our class is implements servlet interface directly or indirectly that
	// class is nothing but servlet
	// class pushservlet implements servlet --- direct
	// class pushservlet implements httpservlet ---- indirect
	// init(serconfig config),service(serreq req,serres
	// res),destroy(),getservletconfig(),getservletInfo().
	// init method will be executed only once for any no.of requset.

	// Servlet life cycle or servlet object creation:::
	// when you pass the url to server fst it checks web.xml file
	// in web.xml it check for the url in servlet-mapping if is there then it checks
	// servlet name in servlet-mapping
	// then it checks in servlet for the servlet-name if it matches then it checks
	// for the servlet-class
	// if it is there then that class will be executed
	// if the class is not there then we get class not found exception(500)
	// first it checks for the default constructor if it is not there then jvm will
	// create default constructor in compile time
	// if parameter constructor is there and no default constructor then tomcat
	// server will not create object.
	// will get no such method exception(500)
	// if any thing wrong in url it self it means server is not able handle the url
	// then (404)
	// parameter constrcutor will not called at any time.
	// tomcat server creates object so default constructor will be called then inti
	// method will be executed and service method will be executed.
	// when we execute same url for next time it check object is there tomcat
	// server.object is already there so constrcutor and inti(config) will not be executed
	// but service method will be executed for any no.of times
	// destroy() method will be executed when we undeploye the project or when we
	// restart the server or when we do any modifications

	// we can place all our classes directly inside the project if its not required
	// security
	// if the classes want to execute after getting permission means out side person
	// is not allowed to access our classes directly then we should define in
	// WEB-INF folder
	// in WEB-INF folder consist classes,lib,web.xml

	// we can place any html files directly inside the project if you dont want to
	// get any error we when call url as project name
	// we have to specify the complete url

	// if we have requirement to write some statements that we have to execute only
	// once then we shold place it in init(config)
	// getting connection and registering driver etc.
	// if we get connection we have to close the connection that we should better to
	// place in destroy().
	// because if we place in service method for the first time it will be it will
	// get connection and it will close
	// when we call second time it will not get any connection it will try to close
	// then will get null
	// inti(config) can be used to initialize the instance variables.
	// if we are not initialize in init and trying to access in service method then
	// will get null pointer exception

	// if we use servlet interface we have to provide implementation for all
	// methods.
	// but we are using only service method to execute some info
	// so they have introduced genericservlet
	// they implemented all the method except service they define service method as
	// abstract
	// so we can provide implementation only for service method
	// if we have a requirement to use init() they have given init() with out
	// parameter.
	// if we over ride init(config) in our class.out class init() method will be
	// executed and if trying to access anything will get null piinter exception
	// because implementation provided in genericservlet class
	// to avoid null pointer exception we have to call super class inti method super keyword
	// so no need to over ride init(config).if we want we can use init()

}
