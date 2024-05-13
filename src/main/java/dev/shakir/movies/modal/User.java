package dev.shakir.movies.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    private ObjectId id;
    private String userName;
    private String email;
    private String password;
    private boolean accountNotExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enable;

    @DocumentReference
    private Set<UserRole> userRoles;


    public User(String email,String userName, String password){

        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

          Set<GrantedAuthority> authorities = new HashSet<>();
          for(UserRole userRole : userRoles){
              authorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));
          }
          return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNotExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;}

    @Override
    public boolean isEnabled() {
        return this.enable;
    }
}
