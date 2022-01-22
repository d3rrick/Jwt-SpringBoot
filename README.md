## Jwt-SpringBoot
Implementing JWT authentication with spring boot.

##### Normally you would create an endpoint to create the credentials(token),
then this token is passed to other requests in the headers(Authorization: Bearer {token})

- Step 1.
    - create token: 
        - url -> ```localhost:8080/auth/generate```
        - There needs to be a user in the backened from db,oauth,azure,aws etc, so the user details is then passed e.g ```(username, password)```
        - ```{"username":"user","password":"5H5_ECC@F][^gtQeu:d,&$sAx>,+EN"}```
          - response. has the jwt token to he passed to other requests.
            - ```{"access_token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjQyODU0NjY0LCJleHAiOjE2NDI4NTUyNjR9.gD04xuNKVsvZX1DrvTNKDArL3RzcSSmKVRltiQNuLcw","expires_in": 600000}```
- Step 2.
  - Pass the token in headers on req 2. ```localhost:8080/greet/```
    - headers ```Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjQyODU0NjY0LCJleHAiOjE2NDI4NTUyNjR9.gD04xuNKVsvZX1DrvTNKDArL3RzcSSmKVRltiQNuLcw```

#### Next steps
- Add exception handlers

© Copyright 2022 [@derrick](https://www.linkedin.com/in/derrick-mutwiri-7a0723122/).