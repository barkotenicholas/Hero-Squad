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
        hero = new Hero("Hulk",43,"strength","Ego");
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
    @Test
    @DisplayName("Check if age returns correctly")
    public void heroInstantiatesWithAge(){
        assertEquals(43,hero.getAge());
    }

    @Test
    @DisplayName("check if power returns correctly")
    public void heroInstantiatesWithPower(){
        assertEquals("strength",hero.getStrength());
    }

    @Test
    @DisplayName("check if weakness returns correctly")
    public void heroInstantiatesWithWeakness(){
        assertEquals("Ego",hero.getWeakness());
    }
}