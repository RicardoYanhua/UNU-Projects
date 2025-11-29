package com.yanhua.app.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
    private Integer userId;
	
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;
    
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Perfil perfil;
    
    @Column(name = "isGoogle")
    private boolean isGoogle;
    
    @Lob
    @Column(name = "picture", nullable = true)
    private String picture;

    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		name = "userRole",
    		joinColumns = {@JoinColumn(name = "userId")},
    		inverseJoinColumns = {@JoinColumn(name = "roleId")}
    		)
    private Set<Role> authorities;	
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
