package com.ormonetomany.bootstrap;

import com.ormonetomany.entity.Address;
import com.ormonetomany.entity.Person;
import com.ormonetomany.repository.AddressRepository;
import com.ormonetomany.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person("Mike", "Smith");
        Person p2 = new Person("Tom", "Hanks");
        Person p3 = new Person("Tedd", "Warner");

        Address a1 = new Address("King St.", "22042");
        Address a2 = new Address("Penn St.", "24031");
        Address a3 = new Address("M St.", "21550");

//        p1.setAddress(Arrays.asList(a1, a2)); //case 1
        personRepository.save(p1);

        a1.setPerson(p1);
        a2.setPerson(p1);
        a3.setPerson(p1);

        addressRepository.save(a1);
        addressRepository.save(a2);
        addressRepository.save(a3);
    }
}
