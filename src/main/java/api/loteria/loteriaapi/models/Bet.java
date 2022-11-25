package api.loteria.loteriaapi.models;

import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.databind.JavaType;

import lombok.Data;

/*
 * This class represents the creation of a lottery bet.
 *
 * Contains tickets related to such a bet and your raffle numbers
 * in addition to drawing the numbers of the bet.
 * 
 * @author Weslley Addson Silva de Carvalho
 */


@Entity
@Data
@TypeDefs({
    @TypeDef(name = "json", typeClass = JavaType.class)
})
public class Bet {


    // Id of bet
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    // Ticket of bet
    @OneToMany
    @JoinColumn(name="bet_id")
    private List<Ticket> tickets;

    // raffle numbers
    @Type(type = "json")
    @Column(nullable = true)
    private List<Integer> raffleNumbers;

    // maximum numbers accepted of bet
    @Column(nullable = false)
    private int totalNumbers;

    // maximum numbers accepted in the raffle by Users
    @Column(nullable = false)
    private int maxNumbersByUsers;

    public void getNumbers(int quantity){
        int count = 0;
        while (count <= quantity || count <= totalNumbers){
            break;
        }
    }

    public int generateRandomNumber(){
        return new Random().nextInt(this.totalNumbers);
    }

}
