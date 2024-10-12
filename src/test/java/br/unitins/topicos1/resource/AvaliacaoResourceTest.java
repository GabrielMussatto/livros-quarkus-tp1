// package br.unitins.topicos1.resource;

// import org.junit.jupiter.api.Test;

// import br.unitins.topicos1.dto.AvaliacaoDTO;
// import br.unitins.topicos1.dto.Response.AvaliacaoResponseDTO;
// import br.unitins.topicos1.service.AvaliacaoService;
// import io.quarkus.test.junit.QuarkusTest;
// import io.quarkus.test.security.TestSecurity;

// import jakarta.inject.Inject;
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.junit.jupiter.api.Assertions.assertNull;
// import static org.hamcrest.CoreMatchers.notNullValue;
// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.is;
// import io.restassured.http.ContentType;

// @QuarkusTest
// public class AvaliacaoResourceTest {

//     @Inject
//     AvaliacaoService avaliacaoService;

//      @Test
//     @TestSecurity(user = "teste", roles = {"Funcionario", "Cliente"})
//     public void findAllTest() {
//         given()
//             .when()
//             .get("/avaliacoes")
//             .then()
//             .statusCode(200);
//     }

//     @Test
//     @TestSecurity(user = "tester", roles = "Funcionario")
//     public void findByIdTest() {
//         given()
//             .when()
//             .get("/avaliacoes/2")
//             .then()
//             .statusCode(200);
//     }

//     @Test
//     @TestSecurity(user = "teste", roles = {"Cliente"})
//     public void createTest() {
//         AvaliacaoDTO avaliacao = new AvaliacaoDTO(
//             "muito legal",
//             5,
//             3L,
//             2L);

//     given()
//             .contentType(ContentType.JSON)
//             .body(avaliacao)
//             .when().post("/avaliacoes")
//             .then()
//             .statusCode(201)
//             .body("id", notNullValue(),                        
//                     "estrela.label", is("⭐⭐⭐⭐⭐"));

//     }

//     @Test
//     @TestSecurity(user = "teste", roles = {"Cliente"})
//     public void updateTest() {
//         AvaliacaoDTO avaliacao = new AvaliacaoDTO(
//                 "muito bão",
//                 5,
//                 5L,
//                 2L);

//         Long id = avaliacaoService.create(avaliacao).id();

//         AvaliacaoDTO avaliacaoUpdate = new AvaliacaoDTO(
//                 "Ruim",
//                 1,
//                 2l,
//                 3l);

//         given()
//                 .contentType(ContentType.JSON)
//                 .body(avaliacaoUpdate)
//                 .when().put("/avaliacoes/" + id)
//                 .then()
//                 .statusCode(204);

//         AvaliacaoResponseDTO avaliacaoResponse = avaliacaoService.findById(id);

//         assertThat(avaliacaoResponse.comentario(), is("Ruim"));
//         assertThat(avaliacaoResponse.estrela().getLabel(), is("⭐"));
//     }

//     @Test
//     @TestSecurity(user = "teste", roles = {"Funcionario", "Cliente"})
//     public void deleteTest() {
//         AvaliacaoDTO avaliacao = new AvaliacaoDTO(
//                 "muito bão",
//                 5,
//                 3l,
//                 2l);

//         Long id = avaliacaoService.create(avaliacao).id();

//         given()
//                 .when().delete("/avaliacoes/" + id)
//                 .then()
//                 .statusCode(204);

//         AvaliacaoResponseDTO avaliacaoResponse = null;

//         try {

//             avaliacaoResponse = avaliacaoService.findById(id);
//         } catch (Exception e) {

//         } finally {
//             assertNull(avaliacaoResponse);
//         }
//     }
// }
