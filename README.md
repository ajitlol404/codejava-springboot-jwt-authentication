# codejava-springboot-jwt-authentication

//for getting token
curl -v -H "Content-Type: application/json" -d "{\"email\":\"your_email@mail.com\",\"password\":\"your_pass\"}" localhost:8080/auth/login

//accessing api with token
curl -v -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d "{\"name\":\"Mi smartphone\",\"price\":\"123\"}" localhost:8080/products
