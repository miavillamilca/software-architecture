package arqsoft.course.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@NamedQueries({
  @NamedQuery(name = Course.FIND_ALL, query = "SELECT u FROM Course u")})
public class Course {

    public static final String FIND_ALL = "Course.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long credits;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
      return name;
    }
    public void setName(String name){
      this.name = name;
    }

    public Long getCredits() {
        return credits;
    }
    public void setCredits(Long credits) {
        this.credits = credits;
    }
}
