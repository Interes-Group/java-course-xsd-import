# Java Web services with WSDL
![License MIT](https://img.shields.io/badge/License-MIT-green)
![Java 1.8](https://img.shields.io/badge/Java-1.8-blue)


Cieľom projektu je demonštrovať jednoduchú SAO aplikáciu s webovými službami definované pomocou WSDL schémy.
Aplikácia implementuje spracovanie WSDL schémy pre webové služby,
spracovanie XML súborov pre automatické generovanie POJO tried.

Vygenerované triedy sú umiestnené v `target/generated-sources/main/java/`.

## Web service
Aplikácia implementuje webovú službu s dvomi endpointami `http://localhost:8080/book`, `http://localhost:8080/paper`.
Webové služby vrácajú zoznam kníh / publikácií v aplikácii.

### Test
Testovať implementovanú webovú službu je možné pomocou [SoapUI](https://www.soapui.org/),
alebo cez cUrl.

#### Book
Request
```
curl -v -H "Content-Type: text/xml; charset=utf-8" -d "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body/></soapenv:Envelope>" -X POST http://localhost:8080/book  
```

Response
```
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Body>
		<ns4:listResponse xmlns="papers" xmlns:ns2="author" xmlns:ns3="books" xmlns:ns4="publisher">
			<ns3:book isbn="978-000-748-830-8">
				<ns3:name>The Lord of the Rings: The Fellowship of the Ring</ns3:name>
				<ns3:type>kniha</ns3:type>
				<ns3:price>10.0</ns3:price>
				<ns3:authors>
					<ns2:name>John</ns2:name>
					<ns2:middle_name>Ronald Reuel</ns2:middle_name>
					<ns2:surname>Tolkien</ns2:surname>
				</ns3:authors>
			</ns3:book>
		</ns4:listResponse>
	</S:Body>
</S:Envelope>
```

#### Paper
Request
```
curl -v -H "Content-Type: text/xml; charset=utf-8" -d "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header/><soapenv:Body/></soapenv:Envelope>" -X POST http://localhost:8080/paper  
```

Response
```
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Body>
		<ns4:listResponse xmlns="papers" xmlns:ns2="author" xmlns:ns3="books" xmlns:ns4="publisher">
			<paper>
				<name>COMPUTING MACHINERY AND INTELLIGENCE</name>
				<authors>
					<ns2:name>Alan</ns2:name>
					<ns2:middle_name>Mathison</ns2:middle_name>
					<ns2:surname>Turing</ns2:surname>
				</authors>
				<doi>10.1093/mind/LIX.236.433</doi>
			</paper>
		</ns4:listResponse>
	</S:Body>
</S:Envelope>
```

## Build
Pre kompilovanie aplikácie
```
mvn clean package
```

## Run
Pre spustenie aplikácie
```
java -jar target/java-course-xsd-import-1.0.0.jar
```