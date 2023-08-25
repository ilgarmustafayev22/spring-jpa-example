package az.atlacademy.springuserapp.service;

import az.atlacademy.springuserapp.model.dto.UserDto;
import az.atlacademy.springuserapp.model.request.CreateUserRequest;
import az.atlacademy.springuserapp.model.request.UpdateUserRequest;

import java.util.List;

public interface IUserService {

    UserDto createUser(CreateUserRequest request);

    List<UserDto> findAllUsers();

    UserDto findById(long id);

    UserDto findByName(String name);

    UserDto updateUser(long id, UpdateUserRequest request);

    void deleteUser(long id);

}
