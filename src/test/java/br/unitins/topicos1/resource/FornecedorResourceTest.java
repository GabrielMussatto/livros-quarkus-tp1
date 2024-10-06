package br.unitins.topicos1.resource;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class FornecedorResourceTest {
 
    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findAllTest() {
        
        given()
            .when()
            .get("/fornecedores")
        .then()
            .statusCode(200)
            .body("nome", hasItems("Loja Moderna Ltda", "TesteFornecedor2", "Sextante Ltda", "Livraria Cultura Ltda" , "Saraiva S.A." , "Editora Abril Ltda"));
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByIdTest() {
        
        given()
            .when()
            .get("/fornecedores/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByNomeTest() {
        
        given()
            .when()
            .get("/fornecedores/search/nome/Sextante")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Sextante Ltda")));    
    } 

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByEstadoTest() {
        
        given()
            .when()
            .get("/fornecedores/search/estado/São")
            .then()
            .statusCode(200)
            .body("estado", everyItem(containsString("Paulo")));
    }
   
    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByCnpjTest() {
        
        given()
            .when()
            .get("/fornecedores/search/cnpj/333")
            .then()
            .statusCode(200)
            .body("cnpj", everyItem(containsString("333")));
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByCidadeTest() {
       
        given()
            .when()
            .get("/fornecedores/search/cidade/São")
            .then()
            .statusCode(200)
            .body("cidade", everyItem(containsString("Paulo")));
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void createTest() {
        TelefoneDTO telefoneDTO = new TelefoneDTO("63", "125487");
        FornecedorDTO dto = new FornecedorDTO(
            "TesteFornecedor",
            "12345678901234",
            "123456789",
            "Testfornecedor@gmail.com",
            "Rua 123",
            "12345-678",
            "Tocantins",
            "Palmas",
            telefoneDTO,
            100
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/fornecedores")
            .then()
            .statusCode(201)
            .body("nome", is("TesteFornecedor"))
            .body("cnpj", is("12345678901234"))
            .body("inscricaoEstadual", is("123456789"))
            .body("email", is("Testfornecedor@gmail.com"))
            .body("endereco", is("Rua 123"))
            .body("cep", is("12345-678"))
            .body("estado", is("Tocantins"))
            .body("cidade", is("Palmas"))
            .body("telefone.codigoArea", is("63"))
            .body("telefone.numero", is("125487"))
            .body("quantLivrosFornecido", is(100));
    }

    
    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void updateTest() {
        TelefoneDTO telefoneDTO = new TelefoneDTO("65", "654");
        FornecedorDTO dto = new FornecedorDTO(
            "TesteFornecedor2",
            "321654987",
            "654321987",
            "Testfornecedor2@gmail.com",
            "Rua 321",
            "32165-678",
            "Tocantins",
            "Araguaina",
            telefoneDTO,
            150
        );
        
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .pathParam("id", 2)
            .put("/fornecedores/{id}")
            .then()
            .statusCode(204);
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void deleteTest() {
       
        given()
            .when()
            .pathParam("id", 7)
            .delete("/fornecedores/{id}")
            .then()
            .statusCode(204);
    }
    
}
