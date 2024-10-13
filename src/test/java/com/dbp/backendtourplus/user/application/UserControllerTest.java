package com.dbp.backendtourplus.user.application;

import com.dbp.backendtourplus.exceptions.ResourceNotFoundException;
import com.dbp.backendtourplus.user.domain.Role;
import com.dbp.backendtourplus.user.domain.User;
import com.dbp.backendtourplus.user.domain.UserService;
import com.dbp.backendtourplus.user.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserControllerTest {

    private UserController userController;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = Mockito.mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User();
        User user2 = new User();
        when(userService.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> response = userController.getAllUsers();

        assertEquals(2, response.size());
        verify(userService, times(1)).findAll();
    }

    @Test
    void testGetUserById_Found() {
        Long userId = 1L;
        User user = new User();
        when(userService.findById(userId)).thenReturn(Optional.of(user));

        ResponseEntity<User> response = userController.getUserById(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void testGetUserById_NotFound() {
        Long userId = 1L;
        when(userService.findById(userId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userController.getUserById(userId));
    }

    @Test
    void testCreateUser() {
        UserDto userDto = new UserDto();
        userDto.setFirstname("John");
        userDto.setLastname("Doe");
        userDto.setEmail("john.doe@example.com");
        userDto.setPassword("password123");
        userDto.setRole(Role.USER);

        User savedUser = new User();
        when(userService.createUser(any(User.class))).thenReturn(savedUser);

        ResponseEntity<User> response = userController.createUser(userDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(savedUser, response.getBody());
        verify(userService, times(1)).createUser(any(User.class));
    }

    @Test
    void testUpdateUser() {
        Long userId = 1L;
        UserDto userDto = new UserDto();
        User updatedUser = new User();
        when(userService.updateUser(userId, userDto)).thenReturn(updatedUser);

        ResponseEntity<User> response = userController.updateUser(userId, userDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedUser, response.getBody());
        verify(userService, times(1)).updateUser(userId, userDto);
    }

    @Test
    void testDeleteUser() {
        Long userId = 1L;
        when(userService.findById(userId)).thenReturn(Optional.of(new User()));
        doNothing().when(userService).deleteById(userId);

        ResponseEntity<Void> response = userController.deleteUser(userId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userService, times(1)).deleteById(userId);
    }

    @Test
    void testDeleteUser_NotFound() {
        Long userId = 1L;
        when(userService.findById(userId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userController.deleteUser(userId));
    }

}
