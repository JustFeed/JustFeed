/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;



import Database.Database;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;

/**
 *
 * @author dcuvelie
 */
public class Klant {
    
    
    private String naam;     //bedrijf = bedrijfsnaam, particulier = naam klant
    private String voornaam;
    private String gebruikersnaam;
    private String email;
    private int postcode;
    private String gemeente;
    private int huisnummer;
    private int gsmnummer;
    private String password;
    private String straatnaam;
    
    Database db = new Database();
    
    public Klant()
    {}
    
  
    public Klant (String naam, String voornaam, String gebruikersnaam, String email, int postcode, String gemeente, int huisnummer, int gsmnummer, String password, String straatnaam)
    {
        this.naam = naam;
        this.voornaam = voornaam;
        this.email = email;
        this.postcode = postcode;
        this.gebruikersnaam = gebruikersnaam;
        this.gemeente = gemeente;
        this.huisnummer = huisnummer;
       this.straatnaam = straatnaam;
        this.gsmnummer = gsmnummer;

        this.password = password;

    }
    
    public String getVoornaam()
    {
        return this.voornaam;
    }
    
    public void setVoornaam (String voornaam)
    {
        this.voornaam = voornaam;
    }
    
    public String getNaam()
    {
        return this.naam;
    }
    
    public void setNaam(String naam)
    {
        this.naam = naam;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    
}
