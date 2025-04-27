package br.gabnsoares.marketplace.controller.dto;

public record CreateUserDto(String fullName,
                            String address,
                            String number,
                            String complement) {
}
