package it.linksmt.academy.micro.course.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.linksmt.academy.micro.course.model.Course;
import it.linksmt.academy.micro.course.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
@Tag(name = "course", description = "The course API")
public class CourseController {

    @Autowired
    private CourseService courseService;

    Logger logger = LoggerFactory.getLogger(CourseController.class);

    @GetMapping
    @Operation( summary = " List all courses")
    public ResponseEntity<List<Course>> getcourses() {

        logger.info("Get all courses");

        return ResponseEntity.ok(courseService.getAll());

    }

    @ApiResponses(value = {
                            @ApiResponse(responseCode = "200",
                                         description = "course the book",
                                         content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class)) }
                                        ),
                            @ApiResponse(responseCode = "400",
                                         description = "Invalid id supplied",
                                         content = @Content),
                            @ApiResponse(responseCode = "404",
                                         description = "course not found",
                                          content = @Content)
                           }
                 )
    @GetMapping("/{id}")
    public ResponseEntity<Course> getcourse(@PathVariable Long id) {

        logger.info("Get single courses");

        return ResponseEntity.ok(courseService.getCourse(id));

    }

    @PostMapping()
    public ResponseEntity<Course> insertcourse(@RequestBody Course course) {

        logger.info("Post single course");

        return ResponseEntity.ok( courseService.insert(course));

    }

    @PutMapping("/{id})")
    public ResponseEntity<Course> updatecourse(@Valid @RequestBody Course course) {

        logger.info("Update single course");
        return ResponseEntity.ok(courseService.update(course));

    }

    @DeleteMapping("/{id})")
    public void deletecourse(Long id) {

        logger.info("Delete single courses");
        courseService.delete(id);

    }

}
