package com.personal.district.user.controller;

import com.personal.district.user.model.Feedback;
import com.personal.district.user.model.User;
import com.personal.district.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register User
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // Get User by Email
    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    // Add Event to Wishlist
    @PostMapping("/{userId}/wishlist/{eventId}")
    public ResponseEntity<User> addEventToWishlist(@PathVariable String userId, @PathVariable String eventId) {
        User updatedUser = userService.addEventToWishlist(userId, eventId);
        return ResponseEntity.ok(updatedUser);
    }

    // Get User Wishlist
    @GetMapping("/{userId}/wishlist")
    public ResponseEntity<List<String>> getUserWishlist(@PathVariable String userId) {
        List<String> wishlist = userService.getUserWishlist(userId);
        return ResponseEntity.ok(wishlist);
    }

    // Remove Event from Wishlist
    @DeleteMapping("/{userId}/wishlist/{eventId}")
    public ResponseEntity<User> removeEventFromWishlist(@PathVariable String userId, @PathVariable String eventId) {
        User updatedUser = userService.removeEventFromWishlist(userId, eventId);
        return ResponseEntity.ok(updatedUser);
    }

    // Add Feedback
    @PostMapping("/{userId}/feedback/{eventId}")
    public ResponseEntity<User> addFeedback(@PathVariable String userId, @PathVariable String eventId,
                                            @RequestParam int rating, @RequestParam String comment) {
        User updatedUser = userService.addFeedback(userId, eventId, rating, comment);
        return ResponseEntity.ok(updatedUser);
    }

    // Get User Feedback
    @GetMapping("/{userId}/feedback")
    public ResponseEntity<List<Feedback>> getUserFeedback(@PathVariable String userId) {
        List<Feedback> feedbacks = userService.getUserFeedback(userId);
        return ResponseEntity.ok(feedbacks);
    }

    //Get All Users
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
