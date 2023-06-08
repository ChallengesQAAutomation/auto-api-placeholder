Feature: Post

Scenario: Obtener listado de los posts
Given I perform a GET request to posts
Then the response status code should be 200
And the response should contain the following attributes:
| id     |
| title  |
| body   |
| userId |
