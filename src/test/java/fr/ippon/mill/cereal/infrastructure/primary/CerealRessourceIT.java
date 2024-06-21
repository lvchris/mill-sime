package fr.ippon.mill.cereal.infrastructure.primary;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Disabled("Should be implemented during the exercise")
class CerealRessourceIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_create_new_cereal_transaction() throws Exception {
        // Given
        mockMvc.perform(post("/api/farmers")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8)
                .content("""
                        {
                        "email": "jean.dupont@fermier.fr",
                        "firstName": "Jean",
                        "lastName": "Dupont",
                        "phoneNumber": "+33 123456789"
                        }
                        """));

        // When
        mockMvc.perform(post("/api/cereals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .content("""
                                {
                                  "cereal": "BLE",
                                  "farmerId": "a046b054-1eae-451d-afa1-8b3202f1902a",
                                  "deliveryDate": "2022-11-21",
                                  "quantity": 7.23
                                }
                                """))
                // Then
                .andExpect(status().isOk());
    }
}
