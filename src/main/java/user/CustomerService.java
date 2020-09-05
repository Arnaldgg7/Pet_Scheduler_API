package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PetRepository petRepository;

    public Customer createCustomer(Customer customer, List<Long> idPetList) {
        List<Pet> petList = new ArrayList<>();
        if (idPetList != null && !idPetList.isEmpty()) {
            petList = idPetList.stream()
                    .map(p -> petRepository.getOne(p)).collect(Collectors.toList());
        }
        customer.setPets(petList);
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer findCustomerByPet(Long petId) {
        return petRepository.getOne(petId).getCustomer();
    }

}
