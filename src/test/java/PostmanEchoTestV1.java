import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTestV1 {


    @Test
    public void shouldReturnBody() {

        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("what is it") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("what is it"))
        ;


    }

    @Test
    public void shouldReturnHeaders() {

        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain;  charset=ISO-8859-1")
                .body("what is it") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("headers.host", equalTo("postman-echo.com"))
        ;


    }


}
