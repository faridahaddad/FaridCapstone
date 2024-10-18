package com._concept.Gobank;

import com._concept.Gobank.model.CreditCardProduct;
import com._concept.Gobank.repository.CreditCardProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
//
@DataJpaTest
public class CreditCardProductRepositoryTest {

    @Autowired
    private CreditCardProductRepository creditCardProductRepository;

    @BeforeEach
    void setUp() {
        CreditCardProduct card1 = new CreditCardProduct();
        card1.setCreditName("GO Platinum");
        card1.setBonus("200");
        card1.setDescription("APR: 12.99% - 18.99% (Variable)");
        card1.setImageUrl("http://localhost:8085/GoPlatinum.png");
        card1.setCreatedAt(LocalDateTime.now());

        CreditCardProduct card2 = new CreditCardProduct();
        card2.setCreditName("GO Travel");
        card2.setBonus("300");
        card2.setDescription("APR: 17.99% - 24.99% (Variable)");
        card2.setImageUrl("http://localhost:8085/GoTravelCard.png");
        card2.setCreatedAt(LocalDateTime.now().minusDays(1));

        CreditCardProduct card3 = new CreditCardProduct();
        card3.setCreditName("GO Cashback Plus");
        card3.setBonus("400");
        card3.setDescription("APR: 16.99% - 23.99% (Variable)");
        card3.setImageUrl("http://localhost:8085/GoCashBack.png");
        card3.setCreatedAt(LocalDateTime.now().minusDays(2));

        CreditCardProduct card4 = new CreditCardProduct();
        card4.setCreditName("GO Student");
        card4.setBonus("500");
        card4.setDescription("APR: 19.99% - 25.99% (Variable)");
        card4.setImageUrl("http://localhost:8085/GoStudent.png");
        card4.setCreatedAt(LocalDateTime.now().minusDays(3));

        creditCardProductRepository.save(card1);
        creditCardProductRepository.save(card2);
        creditCardProductRepository.save(card3);
        creditCardProductRepository.save(card4);
    }








    @Test
    void testFindById() {
        Long id = creditCardProductRepository.findAll().get(0).getId();
        Optional<CreditCardProduct> foundCard = creditCardProductRepository.findById(id);

        assertTrue(foundCard.isPresent());
        assertEquals("GO Platinum", foundCard.get().getCreditName());
    }
    @Test
    void testDeleteById() {
        Long id = creditCardProductRepository.findAll().get(0).getId();
        creditCardProductRepository.deleteById(id);

        Optional<CreditCardProduct> deletedCard = creditCardProductRepository.findById(id);
        assertFalse(deletedCard.isPresent());
    }

    @Test
    void testSaveCreditCardProduct() {
        CreditCardProduct newCard = new CreditCardProduct();
        newCard.setCreditName("GO Business");
        newCard.setBonus("600");
        newCard.setDescription("APR: 14.99% - 20.99% (Variable)");
        newCard.setImageUrl("http://localhost:8085/GoBusiness.png");
        newCard.setCreatedAt(LocalDateTime.now());

        CreditCardProduct savedCard = creditCardProductRepository.save(newCard);

        assertNotNull(savedCard.getId());
        assertEquals("GO Business", savedCard.getCreditName());
    }
}