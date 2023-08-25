package az.atlacademy.springuserapp.service.impl;

import az.atlacademy.springuserapp.dao.entity.UserEntity;
import az.atlacademy.springuserapp.dao.repository.UserRepository;
import az.atlacademy.springuserapp.exception.UserNotFoundException;
import az.atlacademy.springuserapp.model.dto.UserDto;
import az.atlacademy.springuserapp.model.request.CreateUserRequest;
import az.atlacademy.springuserapp.model.request.UpdateUserRequest;
import az.atlacademy.springuserapp.service.IUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDto createUser(CreateUserRequest request) {
        UserEntity userEntity = UserEntity.builder()
                .name(request.getName())
                .age(request.getAge())
                .job(request.getJob())
                .addres(request.getAddres())
                .build();
        UserEntity savedEntity = userRepository.save(userEntity);

        UserDto userDto = new UserDto(savedEntity.getId(),
                savedEntity.getName(),
                savedEntity.getAge(),
                savedEntity.getJob(),
                savedEntity.getAddres());

        return userDto;
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        ArrayList<UserDto> userDtos = new ArrayList<>();

        for (UserEntity userEntity : userEntities) {
            UserDto userDto = new UserDto(userEntity.getId(),
                    userEntity.getName(),
                    userEntity.getAge(),
                    userEntity.getJob(),
                    userEntity.getAddres());
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public UserDto findById(long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        UserEntity userEntity = userOptional.get();
        UserDto userDto = new UserDto(userEntity.getId(),
                userEntity.getName(),
                userEntity.getAge(),
                userEntity.getJob(),
                userEntity.getAddres());
        return userDto;
    }

    @Override
    public UserDto findByName(String name) {
        Optional<UserEntity> userOptional = userRepository.findByName(name);
        UserEntity userEntity = userOptional.get();
        UserDto userDto = new UserDto(userEntity.getId(),
                userEntity.getName(),
                userEntity.getAge(),
                userEntity.getJob(),
                userEntity.getAddres());
        return userDto;
    }

    @Override
    @Transactional
    public UserDto updateUser(long id, UpdateUserRequest request) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id [" + id + "] not found!"));

        userEntity.setName(request.getName());
        userEntity.setAge(request.getAge());
        userEntity.setJob(request.getJob());
        userEntity.setAddres(request.getAddres());

        UserEntity savedUser = userRepository.save(userEntity);

        UserDto userDto = new UserDto(savedUser.getId(),
                savedUser.getName(),
                savedUser.getAge(),
                savedUser.getJob(),
                savedUser.getAddres());
        return userDto;
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userRepository.findById(id)
                .ifPresent(userEntity -> userRepository.deleteById(id));
    }


}
