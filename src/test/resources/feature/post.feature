Feature: Post

Scenario: Obtener un recurso
Given I perform a GET request to "https://jsonplaceholder.typicode.com/posts/1"
Then the response status code should be 200
And the response should contain the following attributes:
| id     |
| title  |
| body   |
| userId |
