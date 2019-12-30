package com.adrrriannn.invoice.manager.application.api.truck

import com.adrrriannn.invoice.manager.InvoiceManagerApplication
import com.adrrriannn.invoice.manager.context.truck.infrastructure.TruckDto
import com.adrrriannn.invoice.manager.stub.truck.TruckDtoStub
import com.jayway.restassured.RestAssured
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest(classes = [InvoiceManagerApplication::class],
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner::class)
@ActiveProfiles("test")
class TruckControllerAcceptanceShould {

    @Test
    fun `create a truck`() {

        val truckDto = TruckDtoStub.random()

        RestAssured
                .given()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(truckDto)
                .log()
                .all()
                .`when`()
                .post("/trucks")
                .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value())
    }

    @Test
    fun `find a truck`() {

        val createdTruckDto = createTruck()

        RestAssured
                .given()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .log()
                .all()
                .`when`()
                .get("/trucks/${createdTruckDto.id}")
                .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value())
    }


    private fun createTruck(): TruckDto {

        val truckDto = TruckDtoStub.random()

        return RestAssured
                .given()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(truckDto)
                .log()
                .all()
                .`when`()
                .post("/trucks")
                .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value())
                .and()
                .extract()
                .`as`(TruckDto::class.java)
    }
}