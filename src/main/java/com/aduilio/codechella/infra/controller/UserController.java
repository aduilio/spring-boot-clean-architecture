package com.aduilio.codechella.infra.controller;

import com.aduilio.codechella.application.usecase.CreateUser;
import com.aduilio.codechella.application.usecase.ListUsers;
import com.aduilio.codechella.domain.entity.user.User;
import com.aduilio.codechella.infra.dto.user.UserRequest;
import com.aduilio.codechella.infra.dto.user.UserResponse;
import com.aduilio.codechella.infra.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Controller to receive the request for user operations.
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUser createUser;
    private final ListUsers listUsers;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @PostMapping
    @Transactional
    public ResponseEntity<UserResponse> create(final @RequestBody @Valid UserRequest request, final UriComponentsBuilder uriBuilder) {
        final User user = userMapper.mapUserFrom(request);

        user.validate();

        final User result = createUser.create(user);
        final URI uri = uriBuilder.path("/users/{id}").buildAndExpand(result.getId()).toUri();

        final UserResponse response = userMapper.mapUserResponseFrom(result);

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> list() {
        final List<User> result = listUsers.list();

        final List<UserResponse> response = userMapper.mapUserResponseFrom(result);

        return ResponseEntity.ok(response);
    }
}
