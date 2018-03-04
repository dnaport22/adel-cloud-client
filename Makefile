image:
	docker rmi ga_rest_api --force
	sh ./gradlew build -x test
	docker build -t ga_rest_api .

execute:
	docker run -p 8080:8080 ga_rest_api