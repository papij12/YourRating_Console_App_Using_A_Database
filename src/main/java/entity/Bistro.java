package entity;

import javax.persistence.*;

@Entity
public class Bistro {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "B_id")
    private int bId;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Rating")
    private int rating;
    @Basic
    @Column(name = "User_id")
    private int userId;



    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
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

        Bistro bistro = (Bistro) o;

        if (bId != bistro.bId) return false;
        if (rating != bistro.rating) return false;
        if (userId != bistro.userId) return false;
        if (name != null ? !name.equals(bistro.name) : bistro.name != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = bId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + userId;
        return result;
    }

}
