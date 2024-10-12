// package br.unitins.topicos1.resource;
// import org.junit.jupiter.api.Test;

// import br.unitins.topicos1.dto.ClienteDTO;
// import br.unitins.topicos1.dto.TelefoneDTO;
// import br.unitins.topicos1.dto.Response.ClienteResponseDTO;
// import br.unitins.topicos1.service.ClienteService;
// import io.quarkus.test.junit.QuarkusTest;
// import io.quarkus.test.security.TestSecurity;
// import jakarta.ws.rs.core.MediaType;
// import jakarta.inject.Inject;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.Matchers.everyItem;

// import java.time.LocalDate;

// import static org.hamcrest.Matchers.containsString;

// @QuarkusTest
// public class ClienteResourceTest {

//     @Inject
//     public ClienteService clienteService;
 
//     @Test
//     @TestSecurity(user = "teste", roles = "Funcionario")
//     public void findAllTest() {
        
//         given()
//             .when()
//             .get("/clientes")
//             .then()
//             .statusCode(200);
//     }

//     @Test
//     @TestSecurity(user = "teste", roles = "Funcionario")
//     public void findByIdTest() {
        
//         given()
//             .when()
//             .get("/clientes/1")
//             .then()
//             .statusCode(200)
//             .body("id", is(1));
//     }

//     @Test
//     @TestSecurity(user = "teste", roles = "Funcionario")
//     public void findByCpfTest() {
        
//         given()
//             .when()
//             .get("/clientes/search/cpf/12345678901")
//             .then()
//             .statusCode(200)
//             .body("cpf", everyItem(containsString("123")));    
//     }

//     @Test
//     @TestSecurity(user = "teste", roles = "Funcionario")
//     public void findByEstadoTest() {
       
//         given()
//             .when()
//             .get("/clientes/search/estado/Belo")
//             .then()
//             .statusCode(200)
//             .body("estado", everyItem(containsString("Horizonte")));
//     }

//     @Test
//     @TestSecurity(user = "teste", roles = "Cliente")
//     public void createTest() {
//         TelefoneDTO telefoneDTO = new TelefoneDTO("85", "99887766");
//         ClienteDTO dto = new ClienteDTO(
//             "968695",
//             "Rua 80",
//             "João Pessoa",
//             "PB",
//             "Jorge Castanho",
//             "jorge190",
//             LocalDate.parse("2003-03-10"),
//             "jorge.castanho@gmail.com",
//             "fefe", 
//             "18246936398",
//             1, 
//             telefoneDTO
//         );
    
//         given()
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto)
//             .when()
//             .post("/clientes")
//             .then()
//             .statusCode(201)
//             .body("endereco", is("Rua 80"));
//     }
 
//     @Test
//     @TestSecurity(user = "testeCliente2", roles = "Cliente")
//     public void updateTest() {
//         TelefoneDTO telefoneDTO = new TelefoneDTO("95", "453543");
//         ClienteDTO dto = new ClienteDTO(
//             "535252",
//             "Rua 10",
//             "Tocantins",
//             "Palmas",
//             "Jenifer",
//             "jenifer190",
//             LocalDate.parse("2004-03-10"),
//             "Jenifer@gmail.com",
//             "test",
//             "3265326",
//             2, 
//             telefoneDTO
//         );

//         given()
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto)
//             .when()
//             .pathParam("id", 2)
//             .put("/clientes/{id}")
//             .then()
//             .statusCode(204);
//     }
    
//     @Test
//     @TestSecurity(user = "teste", roles = "Cliente")
//     public void deleteTest() {
//         TelefoneDTO telefoneDTO = new TelefoneDTO("62", "33226623");
//         ClienteDTO dto = new ClienteDTO(
//             "978653",
//             "Rua 110",
//             "Toncatins",
//             "Gurupi",
//             "Coral montenegro",
//             "carolassa",
//             LocalDate.parse("2003-03-10"),
//             "carolas@gmail.com",
//             "132", 
//             "21232212",
//             2, 
//             telefoneDTO
//         );

//         ClienteResponseDTO response = clienteService.create(dto);
        
//         given()
//             .when()
//             .pathParam("id", response.id())
//             .delete("/clientes/{id}")
//             .then()
//             .statusCode(204);
//     }

// }

