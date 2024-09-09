package com.personal.district.user.service;

import com.personal.district.user.model.Feedback;
import com.personal.district.user.model.User;
import com.personal.district.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Basic User Operations
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        return userRepository.save(existingUser);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    // Wishlist Operations
    public User addEventToWishlist(String userId, String eventId) {
        User user = getUserById(userId);
        user.getWishlist().add(eventId);
        return userRepository.save(user);
    }

    public List<String> getUserWishlist(String userId) {
        User user = getUserById(userId);
        return user.getWishlist();
    }

    public User removeEventFromWishlist(String userId, String eventId) {
        User user = getUserById(userId);
        user.getWishlist().remove(eventId);
        return userRepository.save(user);
    }

    // Feedback Operations
    public User addFeedback(String userId, String eventId, int rating, String comment) {
        User user = getUserById(userId);
        Feedback feedback = new Feedback();
        feedback.setEventId(eventId);
        feedback.setRating(rating);
        feedback.setComment(comment);
        user.getFeedbacks().add(feedback);
        return userRepository.save(user);
    }

    public List<Feedback> getUserFeedback(String userId) {
        User user = getUserById(userId);
        return user.getFeedbacks();
    }
}