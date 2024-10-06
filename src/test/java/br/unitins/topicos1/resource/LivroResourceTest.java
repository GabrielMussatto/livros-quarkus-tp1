package br.unitins.topicos1.resource;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.LivroDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItems;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.containsString;


@QuarkusTest
public class LivroResourceTest {

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findAllTest() {
        
        given()
            .when()
            .get("/livros")
            .then()
            .statusCode(200)
            .body("titulo", hasItems("Confess", "A Hipotese do Amor", "Livrotext", "Harry Potter e a Pedra Filosofal", "1984", "O Diário da Nossa Paixão"));
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByIdTest() {
        
        given()
            .when()
            .get("/livros/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByTituloTest() {
        
        given()
            .when()
            .get("/livros/search/titulo/Hipotese")
            .then()
            .statusCode(200)
            .body("titulo", everyItem(containsString("Hipotese")));    
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByIsbnTest() {
        
        given()
            .when()
            .get("/livros/search/isbn/97885")
            .then()
            .statusCode(200)
            .body("isbn", everyItem(containsString("97885")));
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByDescricaoTest() {
        
        given()
            .when()
            .get("/livros/search/descricao/jovem")
            .then()
            .statusCode(200)
            .body("descricao", everyItem(containsString("jovem")));
    }


    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void createTest() {
        LivroDTO dto = new LivroDTO(
            "O Senhor dos Anéis",
            List.of(2L, 5L), // IDs dos autores
            1L, // ID da editora
            List.of(5L), // IDs dos gêneros
            39.90, // preço
            50, // quantidade em estoque
            "9788578275060", // ISBN
            LocalDate.parse("2022-03-10"), // data de lançamento
            1, // ID da classificação
            "A saga de um grupo de heróis na Terra Média.", // descrição
            1L // ID do fornecedor
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/livros")
        .then()
            .statusCode(201)
            .body("titulo", is("O Senhor dos Anéis"));
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void updateTest() {
         LivroDTO dto = new LivroDTO(
            "Livrotext",
            List.of(3L, 4L), // IDs dos autores
            3L, // ID da editora
            List.of(5L, 3L), // IDs dos gêneros
            40.90, // preço
            100, // quantidade em estoque
            "3215263418", // ISBN
            LocalDate.parse("2023-10-10"), // data de lançamento
            3, // ID da classificação
            "Livrotext", // descrição
            3L // ID do fornecedor
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/livros/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void deleteTest() {
        
        given()
            .when()
            .pathParam("id", 7)
            .delete("/livros/{id}")
            .then()
            .statusCode(204);
    }

}
