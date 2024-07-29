package com.techspine.crs.entity;

import com.techspine.crs.enums.UserRole;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    @Lob
    @Column(name = "profileImg",columnDefinition = "LONGTEXT")
    private String profileImg;
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    @Column(name = "cars")
    private List<Car> cars;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    public User() {
    }

    public User(int userId, String firstName, String lastName, String email, String password, String profileImg, UserRole role, List<Car> cars) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profileImg = profileImg;
        this.role = role;
        this.cars = cars;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

//    @OneToMany(mappedBy = "userId" , cascade = CascadeType.ALL)
//    @Column(name = "addresses")
//    private List<Address> addresses;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @Column(name = "bookings")
//    private List<Booking> bookings;
//
//    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
//    @Column(name = "cars")
//    private List<Car> cars;
//
//    @OneToMany(mappedBy = "userId" , cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Rating> ratings = new ArrayList<>();
//    @OneToMany(mappedBy = "userId" , cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Reviews> reviews = new ArrayList<>();
//
//    @Embedded
//    @ElementCollection
//    @CollectionTable(name = "payment_information" , joinColumns = @JoinColumn(name = "user_id"))
//    private List<PaymentInformation> paymentInformation = new ArrayList<>();


