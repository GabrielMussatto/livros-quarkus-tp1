// package br.unitins.topicos1.resource;

// import br.unitins.topicos1.dto.PedidoDTO;
// import br.unitins.topicos1.dto.Response.PedidoResponseDTO;
// import br.unitins.topicos1.service.PedidoService;
// import br.unitins.topicos1.dto.ItemPedidoDTO;
// import io.quarkus.test.junit.QuarkusTest;
// import io.quarkus.test.security.TestSecurity;
// import jakarta.ws.rs.core.MediaType;
// import org.junit.jupiter.api.Test;
// import jakarta.inject.Inject;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.is;

// import java.util.Arrays;
// import java.util.List;

// @QuarkusTest
// public class PedidoResourceTest {

//     @Inject
//     public PedidoService pedidoService;

//     @Test
//     @TestSecurity(user = "teste", roles = "Funcionario")
//     public void findAllTest() {
//         given()
//             .when()
//             .get("/pedidos")
//             .then()
//             .statusCode(200);
//     }

//     @Test
//     @TestSecurity(user = "teste", roles = "Funcionario")
//     public void findByIdTest() {
        
//         given()
//             .when()
//             .get("/pedidos/1")
//             .then()
//             .statusCode(200);
//     }

//     @Test
//     @TestSecurity(user = "teste", roles = "Funcionario")
//     public void findByClienteTest() {
//         given()
//             .when()
//             .get("/pedidos/search/clientes/1")
//             .then()
//             .statusCode(200);
//     }

//     @Test
//     @TestSecurity(user = "teste", roles = "Cliente")
//     public void createTest() {
//         ItemPedidoDTO item = new ItemPedidoDTO(1L, 2);
//         PedidoDTO dto = new PedidoDTO(4L, List.of(item));

//         PedidoResponseDTO response = pedidoService.create(dto);

//         given()
//         .pathParam("id", response.id())
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto)
//             .when()
//             .post("/pedidos")
//             .then()
//             .statusCode(201)
//             .body("cliente.id", is(4L));
//     }
    

//     @Test
//     @TestSecurity(user = "teste", roles = "Cliente")
//     public void cancelarPedidoTest() {
//         PedidoResponseDTO response = pedidoService.create(new PedidoDTO(
//             1L,
//             Arrays.asList(new ItemPedidoDTO(3L, 4))
//         ));
        
//         given()
//             .when()
//             .pathParam("id", response.id())
//             .delete("/pedidos/{id}/cancelar-Pedido")
//             .then()
//             .statusCode(204);
//     }
// }
