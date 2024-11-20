package vn.iotstar.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	@Email
	private String email;
	@Column(length = 60, columnDefinition = "nvarchar(50) not null")
	private String name;
	private String password;
	private boolean enabled;
	
	@ManyToAny(cascade = CascadeType.All, fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();
}
