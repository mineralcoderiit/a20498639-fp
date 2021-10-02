package edu.sat.itmd4515.a20498639;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Logger;

public class PetTest {

    public static EntityManagerFactory emf;
    public EntityManager em;
    public EntityTransaction tx;

    private static final Logger LOG = Logger.getLogger(PetTest.class.getName());

    @BeforeAll
    public static void beforeAll(){
        emf =  Persistence.createEntityManagerFactory("itmd4515TestPU");
    }

    @BeforeEach
    public void beforeEach(){
        em = emf.createEntityManager();
        tx = em.getTransaction();

        Pet p = new Pet("TestCase", LocalDate.of(2000,7,22), PetType.CAT);

        tx.begin();
        em.persist(p);
        tx.commit();

        LOG.info(p.toString());
    }


    @AfterEach
    public void afterEach() throws SQLException {

        Pet p = em.createQuery("select p from Pet p where p.name = 'TestCase'", Pet.class).getSingleResult();
        LOG.info(p.toString());
        tx.begin();
        em.remove(p);
        tx.commit();


        em.close();
    }

    @Test
    public void createPetTest() throws SQLException{

        LOG.info("create Pet =====================================");
        Pet createNewPet = new Pet("Morkie", LocalDate.of(1990, 12,20), PetType.DOG);
        tx.begin();
        em.persist(createNewPet);
        tx.commit();

        Pet findNewPet = em.createQuery("select p from Pet p where p.name = 'Morkie'", Pet.class).getSingleResult();

        LOG.info(findNewPet.toString());

        assertNotNull(findNewPet);
        assertTrue(findNewPet.getId() > 0);

        tx.begin();
        em.remove(findNewPet);
        tx.commit();
    }

    @Test
    public void updatePetTest() throws SQLException{
        LOG.info("updatePetTest =================================");

        Pet p = em.createQuery("select p from Pet p where p.name = 'TestCase'", Pet.class).getSingleResult();
        tx.begin();
        p.setType(PetType.BIRD);
        p.setBirthDate(LocalDate.of(2020, 10, 3));
        tx.commit();

        Pet findNewPet = em.createQuery("select p from Pet p where p.name = 'TestCase'", Pet.class).getSingleResult();
        assertEquals(PetType.BIRD, findNewPet.getType());
    }
    @Test
    public void readPetTest() throws SQLException{

        LOG.info("read Pet =====================================");
//        Pet createNewPet = new Pet("Morkie", LocalDate.of(1990, 12,20), PetType.DOG);
//        tx.begin();
//        em.persist(createNewPet);
//        tx.commit();
        Pet findNewPet = em.createQuery("select p from Pet p where p.name = 'Morkie'", Pet.class).getSingleResult();

        LOG.info(findNewPet.toString());

        assertNotNull(findNewPet);
        assertTrue(findNewPet.getId() > 0);

        tx.begin();
        em.remove(findNewPet);
        tx.commit();
    }
    @Test
    public void deletePetTest() throws SQLException{

        LOG.info("delete Pet =====================================");
//        Pet createNewPet = new Pet("Morkie", LocalDate.of(1990, 12,20), PetType.DOG);
//        tx.begin();
//        em.persist(createNewPet);
//        tx.commit();

        Pet findNewPet = em.createQuery("delete p from Pet p where p.name = 'Morkie'", Pet.class).getSingleResult();

        LOG.info(findNewPet.toString());

        assertNotNull(findNewPet);
        assertTrue(findNewPet.getId() > 0);

        tx.begin();
        em.remove(findNewPet);
        tx.commit();
    }
    @AfterAll
    public static void afterAll(){
        emf.close();
    }
}
