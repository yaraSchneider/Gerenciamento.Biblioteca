package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;
    private String senha;

   // @ManyToMany(fetch = FetchType.EAGER)
  //  @JoinTable(
   //     name = "user_role"
   //     joinColuns = 
   // )
}
