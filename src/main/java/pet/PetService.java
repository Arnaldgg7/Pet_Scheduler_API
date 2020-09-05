package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import com.udacity.jdnd.course3.critter.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PetService {
    @Autowired
    PetRepository petRepository;

    @Autowired
    CustomerRepository customerRepository;

    public Pet savePet(Pet pet, Long ownerId) {
        Customer customer = customerRepository.getOne(ownerId);
        pet.setCustomer(customer);
        pet = petRepository.save(pet);
        customer.getPets().add(pet);
        customerRepository.save(customer);
        return pet;
    }

    public Pet findPetById(Long petId) {
        return petRepository.getOne(petId);
    }

    public List<Pet> findAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> findAllPetsByCustomerId(Long customerId) {
        return petRepository.getAllByCustomerId(customerId);
    }
}
