package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    Hero hero;

    @BeforeEach
    public void setUp(){
        hero = new Hero("Hulk");
    }

    @Test
    @DisplayName("Check is Hero Object Gets initiated correctly")
    public void newHeroObjectGetsCreated_true() {
        assertNotNull(hero);
    }

    @Test
    @DisplayName("Check if Name returns correctly")
    public void heroInstantiatesWithName(){
        assertEquals("Hulk",hero.getName());
    }

}