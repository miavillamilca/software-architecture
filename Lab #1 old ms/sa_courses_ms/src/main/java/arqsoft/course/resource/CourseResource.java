package arqsoft.course.resource;

import arqsoft.course.model.Course;
import arqsoft.course.service.CourseService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/course")
public class CourseResource {

    @Context
    UriInfo uriInfo;

    @EJB
    CourseService courseService;

    @GET
    public List<Course> getAllCourses(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult) {
        return courseService.getAllCourses(first, maxResult);
    }

    @GET
    @Path("{id}")
    public Course getCourseById(@PathParam("id") long id) {
        return courseService.getCourseById(id);
    }

    @POST
    public Response createCourse(Course course) {
        courseService.createCourse(course);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response updateCourse(@PathParam("id") long id, Course course) {
        courseService.updateCourse(id, course);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCourse(@PathParam("id") long id) {
        courseService.deleteCourse(id);
        return Response.status(Response.Status.OK).build();
    }

}
