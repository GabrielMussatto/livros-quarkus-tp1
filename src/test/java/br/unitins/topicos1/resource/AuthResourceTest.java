// package br.unitins.topicos1.resource;

// import org.junit.jupiter.api.Test;

// import br.unitins.topicos1.dto.auth.AuthUsuarioDTO;
// import io.quarkus.test.junit.QuarkusTest;

// import static io.restassured.RestAssured.given;

// import io.restassured.http.ContentType;

// @QuarkusTest
// public class AuthResourceTest {

//     @Test
//     public void login() {

//         AuthUsuarioDTO authUsuarioDTO = new AuthUsuarioDTO("Amanda30", "123", 1);

//         given()
//             .contentType(ContentType.JSON)
//             .body(authUsuarioDTO)
//             .when()
//             .post("/auth")
//             .then()
//             .statusCode(201);
//     }

// }
