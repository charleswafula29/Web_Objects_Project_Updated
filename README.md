SERVER END POINTS

1. Create User
	URL: /users
	METHOD: POST
	Body
	{
		"name": "Rue",
		"nationalID": 95885
	}

2. View all users
	URL: /users
	METHOD: GET

3. View all categories
	URL: /categories
	METHOD: GET

4. User to add new movie
	URL: users/{userid}/movies
	METHOD: POST
	Query Parameter: category
	Query Parameter: movieName
	Query Parameter: yearReleased

5. Get user's suggested movies
	URL: users/{nationalId}/movies
	METHOD: GET

6. Delete a user
	URL: users/deleteUser/{userId}
	METHOD: DELETE

7. Find User using their NationalId (used for login)
	URL: users/UserNationalId/{nationalId}
	METHOD: GET

8. User to Delete a movie
	URL: users/{nationalId}/movies/{movieid}
	METHOD: DELETE

9. Search movie by id
	URL: movies/movies/{movieId}
	METHOD: GET

10. Search movie by name
	URL: movies/search
	METHOD: GET
	QueryParameter: movieName


11. User to Update a movie(Not yet Done)
	URL: movies/{nationalId}/movies/{movieid}
	METHOD: PATCH
	Body
	{
		"name": "Emery Out",
		"yearReleased": "2019",
		""
	}
