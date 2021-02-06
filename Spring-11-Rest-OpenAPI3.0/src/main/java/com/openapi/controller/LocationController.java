package com.openapi.controller;

import com.openapi.entity.Location;
import com.openapi.repository.LocationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
@Tag(name = "Location", description = "Location API")
public class LocationController {

    private LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping
    @Operation(summary = "Read all Locations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Location.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Location Not Found", content = @Content)
    })
    public ResponseEntity<List<Location>> readAllLocations() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(locationRepository.findAll());
    }

    @GetMapping("/{name}")
    @Operation(summary = "Read Location by Name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Location.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Location Not Found", content = @Content)
    })
    public ResponseEntity<Location> readByName(@PathVariable("name") String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(locationRepository.findByName(name));
    }

    @PostMapping
    @Operation(summary = "Create Location")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Location.class))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Location.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Location Not Found", content = @Content)
    })
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(locationRepository.save(location));
    }

    @PutMapping("/{name}")
    @Operation(summary = "Update Location")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Location.class))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Location.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Location Not Found", content = @Content)
    })
    public ResponseEntity<Location> updateLocation(@PathVariable("name") String name, @RequestBody Location location) {
        Location foundLocation = locationRepository.findByName(name);
        location.setId(foundLocation.getId());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(locationRepository.save(location));
    }

    @DeleteMapping("/{name}")
    @Operation(summary = "Delete Location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Location.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Location Not Found", content = @Content)
    })
    public ResponseEntity<Location> deleteLocation(@PathVariable("name") String name) {
        Location foundLocation = locationRepository.findByName(name);
        locationRepository.delete(foundLocation);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(foundLocation);
    }

}
