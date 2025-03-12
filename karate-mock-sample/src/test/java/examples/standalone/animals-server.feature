Feature:

Background:
* def catsUrl = "http://localhost:33611"

Scenario: methodIs('post')
* karate.proceed(catsUrl)

Scenario: pathMatches('/cats/{id}')
* def proceedResponse = karate.http(catsUrl + "/cats/" + pathParams.id).get()
* def response = proceedResponse.body

Scenario:
* karate.proceed(catsUrl)