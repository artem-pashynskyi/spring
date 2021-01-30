package com.restlab.controller;

import com.restlab.entity.Address;
import com.restlab.entity.ResponseWrapper;
import com.restlab.entity.Teacher;
import com.restlab.repository.AddressRepository;
import com.restlab.repository.ParentRepository;
import com.restlab.repository.StudentRepository;
import com.restlab.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {

    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private ParentRepository parentRepository;
    private AddressRepository addressRepository;

    public ApiController(TeacherRepository teacherRepository, StudentRepository studentRepository, ParentRepository parentRepository, AddressRepository addressRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents() {
        return ResponseEntity
                .ok(new ResponseWrapper("Students have been successfully retrieved", studentRepository.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents() {
        ResponseWrapper responseWrapper = new ResponseWrapper(
                true,
                "Parents have been successfully retrieved",
                HttpStatus.ACCEPTED.value(),
                parentRepository.findAll()
        );
        return ResponseEntity
                .status(HttpStatus.ACCEPTED.value())
                .body(responseWrapper);
    }

    @PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable("id") Integer id, @RequestBody Address address) throws Exception {
        Optional<Address> foundAddress = addressRepository.findById(id);
        if(!foundAddress.isPresent()) throw new Exception("Address does not exist!");
        address.setCurrentTemperature(new Address().consumeTemp(address.getCity()));
        address.setId(foundAddress.get().getId());
        return addressRepository.save(address);
    }

}
