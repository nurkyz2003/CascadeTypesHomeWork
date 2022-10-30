package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String duration;
    private String createAt;
    private String imageLink;
    private String description;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "course",fetch = FetchType.EAGER)
    private List<Lesson> lessons;

    @ManyToMany(mappedBy = "course",fetch = FetchType.EAGER)
    private List<Instructor> instructors = new ArrayList<>();

    public Course(String name, String duration, String createAt, String imageLink, String description) {
        this.name = name;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", createAt='" + createAt + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
