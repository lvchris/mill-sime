package fr.ippon.mill.cereal.infrastructure.primary;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

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
      MvcResult result = mockMvc.perform(post("/api/farmers")
          .contentType(MediaType.APPLICATION_JSON)
          .characterEncoding(StandardCharsets.UTF_8)
          .content("""
                        {
                        "email": "jean.dupont@fermier.fr",
                        "firstName": "Jean",
                        "lastName": "Dupont",
                        "phoneNumber": "+33 123456789"
                        }
                        """))
        .andReturn();
      String locationHeader = result.getResponse().getHeader("Location");

      String farmerId = locationHeader.substring(locationHeader.lastIndexOf('/') + 1);
        // When
      mockMvc.perform(post("/api/cereals")
          .contentType(MediaType.APPLICATION_JSON)
          .characterEncoding(StandardCharsets.UTF_8)
          .content(String.format("""
                                {
                                  "cereal": "BLE",
                                  "farmerId": "%s",
                                  "deliveryDate": "2022-11-21",
                                  "quantity": 7.23
                                }
                                """, farmerId)))
        // Then
        .andExpect(status().isCreated());
    }
}
