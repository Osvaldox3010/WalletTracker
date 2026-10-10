package com.example.wallettracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.example.wallettracker.model.User;
import com.example.wallettracker.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void getUserByIdThrowsNotFoundWhenUserDoesNotExist() {
        when(userRepository.findById(7L)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> userService.getUserById(7L));

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    @Test
    void updateUserPersistsChanges() {
        User storedUser = new User();
        User request = new User();
        request.setName("Updated");
        request.setLastName("Name");
        request.setEmail("updated@example.com");
        when(userRepository.findById(7L)).thenReturn(Optional.of(storedUser));
        when(userRepository.save(storedUser)).thenReturn(storedUser);

        User updatedUser = userService.updateUser(7L, request);

        assertEquals("Updated", updatedUser.getName());
        assertEquals("Name", updatedUser.getLastName());
        assertEquals("updated@example.com", updatedUser.getEmail());
        verify(userRepository).save(storedUser);
    }

    @Test
    void deleteUserChecksExistenceAndDeletesUser() {
        User storedUser = new User();
        when(userRepository.findById(7L)).thenReturn(Optional.of(storedUser));

        userService.deleteUser(7L);

        verify(userRepository).delete(storedUser);
    }
}
