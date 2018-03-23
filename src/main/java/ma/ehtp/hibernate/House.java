package ma.ehtp.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adress;
    private double averageRate;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Rating> ratings = new ArrayList<>();

    public House(String adress) {
        this.adress = adress;
    }

    public void updateAverageRate() {
//        if (ratings.isEmpty()) averageRate = 0;
//        else {
//            averageRate = ratings.stream().sum ?
//                    / ratings.size()
//        }
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void addRating(Rating rating) {
        this.ratings.add(rating);
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getAverageRate() {
        return averageRate;
    }

 }
