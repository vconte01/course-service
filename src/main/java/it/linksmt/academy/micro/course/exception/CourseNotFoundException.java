package it.linksmt.academy.micro.course.exception;

public class CourseNotFoundException extends RuntimeException{

    private final String message;

    public CourseNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
