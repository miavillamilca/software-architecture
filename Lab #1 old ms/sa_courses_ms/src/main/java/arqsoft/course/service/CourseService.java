package arqsoft.course.service;

import arqsoft.course.model.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CourseService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Course> getAllCourses(int first, int maxResult) {
        return entityManager.createNamedQuery(Course.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public Course getCourseById(long id){
        return entityManager.find(Course.class, id);
    }

    public void createCourse(Course course) {
        entityManager.persist(course);
    }

    public Course updateCourse(long id, Course course) {
        Course courseToUpdate = entityManager.find(Course.class, id);
        courseToUpdate.setName(course.getName());
        courseToUpdate.setCredits(course.getCredits());
        return entityManager.merge(courseToUpdate);
    }

    public void deleteCourse(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
