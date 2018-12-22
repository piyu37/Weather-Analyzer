
package com.itt.weatherdataprocessor.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

/**
 *
 * @author kratiyag.gupta
 */

@Entity
@Table(name = "dailyStatus")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int weatherId;
    @Column
    private String date;
    @Column
    private int maxtempC;
    @Column
    private int maxtempF;
    @Column
    private int mintempC;
    @Column
    private int mintempF;
    
    @Column
    private String city;

    @OrderColumn
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "weatherId")
    private Hourly hourly[];

    public int getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(int maxtempC) {
        this.maxtempC = maxtempC;
    }

    public int getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(int maxtempF) {
        this.maxtempF = maxtempF;
    }

    public int getMintempC() {
        return mintempC;
    }

    public void setMintempC(int mintempC) {
        this.mintempC = mintempC;
    }

    public int getMintempF() {
        return mintempF;
    }

    public void setMintempF(int mintempF) {
        this.mintempF = mintempF;
    }

    public Hourly[] getHourly() {
        return hourly;
    }

    public void setHourly(Hourly[] hourly) {
        this.hourly = hourly;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}
