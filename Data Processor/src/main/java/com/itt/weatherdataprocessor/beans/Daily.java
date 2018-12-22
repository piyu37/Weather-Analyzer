
package com.itt.weatherdataprocessor.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author kratiyag.gupta
 */

@Entity
@Table(name = "dailyStatus")
public class Daily implements Serializable {
    @Id
    private Timestamp date;
    @Column
    private int maxtempC;
    @Column
    private int maxtempF;
    @Column
    private int mintempC;
    @Column
    private int mintempF;
    @Column
    @OneToMany
    @JoinColumn(name = "weather")
    private Hourly hourly[];

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

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
}
