package br.gabnsoares.marketplace.service;

import br.gabnsoares.marketplace.controller.dto.CreateUserDto;
import br.gabnsoares.marketplace.entities.BillingAddressEntity;
import br.gabnsoares.marketplace.entities.UserEntity;
import br.gabnsoares.marketplace.repository.BillingAddressRepository;
import br.gabnsoares.marketplace.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public UserEntity createUser(CreateUserDto dto) {

        var billingAddress = new BillingAddressEntity();
        billingAddress.setAddress(dto.address());
        billingAddress.setNumber(dto.number());
        billingAddress.setComplement(dto.complement());

        var saveBillingAddress = billingAddressRepository.save(billingAddress);

        var user = new UserEntity();
        user.setFullName(dto.fullName());
        user.setBillingAddress(saveBillingAddress);

        return userRepository.save(user);
    }
}
