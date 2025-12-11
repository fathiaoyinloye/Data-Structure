package data.repositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    UserRepository userRepository;
@BeforeEach
    void setUp() {
    userRepository = new UserRepositoryImpl();
    }

    @Test
    void testThatUserRepositoryIsEmpty() {
    assertEquals(0, userRepository.count());
    }

    @Test
    void testThatUserBorrowedBook_CountIsOne() {
        assertEquals(0, userRepository.count());
        User user = new User();
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }

    @Test
    void testThatUserBorrowedBook_CountIsOne_saveReturnUserSaved() {
        assertEquals(0, userRepository.count());
        User user = new User();
        assertEquals(user,userRepository.save(user));
        assertEquals(1, userRepository.count());
    }

    @Test
    void userAandBborrowedBooks_countIsTwo_userBIsDelted_countIsOne() {
        assertEquals(0, userRepository.count());
        User user = new User();
        userRepository.save(user);
        assertEquals(1, userRepository.count());
        User userTwo = new User();
        userRepository.save(userTwo);
        assertEquals(2, userRepository.count());
        userRepository.delete(userTwo);
         assertEquals(1, userRepository.count());


    }
    @Test
     void userIsSaved_userCanBeFindById() {
        assertEquals(0, userRepository.count());
        User user = new User();
        userRepository.save(user);
        assertEquals(1, userRepository.count());
        assertEquals(user,userRepository.findById(1));
     }

    @Test
    void userAIsSaved_findUserB_returnNull() {
        assertEquals(0, userRepository.count());
        User user = new User();
        userRepository.save(user);
        assertEquals(1, userRepository.count());
        assertNull(userRepository.findById(5));
    }
    @Test
    void userAIsSaved_checkForUserAExistenceById() {
        assertEquals(0, userRepository.count());
        User user = new User();
        userRepository.save(user);
        assertEquals(1, userRepository.count());
        assertTrue(userRepository.existById(1));
    }

    @Test
    void userAIsSaved_countIsOne_userInforamationIsUpdatedAndSaveAgain_CountIsOne() {
    assertEquals(0, userRepository.count());
    User user = new User();
    userRepository.save(user);
    assertEquals(1, userRepository.count());
    userRepository.save(user);
    assertEquals(1, userRepository.count());
}

}
