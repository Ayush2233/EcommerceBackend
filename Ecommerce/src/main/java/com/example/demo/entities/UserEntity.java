package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


/* This class if for converting the data from database into User objects */
@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Column(unique = true)
    private  String email;

    @Column
    private long phone;

    @Column
    private String password;


    @Column
    private boolean isActive;

    public List<ProductEntity> getCart() {
        return cart;
    }

    public void setCart(List<ProductEntity> cart) {
        this.cart = cart;
    }

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JsonManagedReference
    @JoinTable(name = "USER_CART",
            joinColumns = {
                    @JoinColumn(name = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "p_id")
            }
    )
    private List<ProductEntity> cart;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JsonManagedReference
    @JoinTable(name = "USER_ROLE",
             joinColumns = {
        @JoinColumn(name = "id")
    },
    inverseJoinColumns = {
        @JoinColumn(name = "role_id")
    }
    )
    private Set<RoleEntity> role;

    @OneToOne
    private AddressEntity addressEntity;


    public UserEntity() {

    }

    public UserEntity(int id, String name, int age, String email, long phone, String password, boolean isActive, List<ProductEntity> cart, Set<RoleEntity> role, AddressEntity addressEntity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.isActive = isActive;
        this.cart = cart;
        this.role = role;
        this.addressEntity = addressEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }



    public AddressEntity getAddress() {
        return addressEntity;
    }

    public void setAddress(AddressEntity address) {
        this.addressEntity = address;
    }

    public Set<RoleEntity> getRole() {
        return role;
    }

    public void setRole(Set<RoleEntity> role) {
        this.role = role;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", cart=" + cart +
                ", role=" + role +
                ", addressEntity=" + addressEntity +
                '}';
    }
}
