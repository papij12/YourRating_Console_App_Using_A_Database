package entity;

import javax.persistence.*;

@Entity
public class Takeaway {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "T_id")
    private int tId;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Rating")
    private int rating;
    @Basic
    @Column(name = "User_id")
    private int userId;


    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Takeaway takeaway = (Takeaway) o;

        if (tId != takeaway.tId) return false;
        if (rating != takeaway.rating) return false;
        if (userId != takeaway.userId) return false;
        if (name != null ? !name.equals(takeaway.name) : takeaway.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + userId;
        return result;
    }
}
