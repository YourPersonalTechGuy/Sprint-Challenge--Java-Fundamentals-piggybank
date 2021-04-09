package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.PiggyBankCoin;
import com.lambdaschool.piggybank.repositories.PiggyBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PiggyBankController {
    @Autowired
    private PiggyBankRepository PiggyBankRepo;

    // http://localhost:2019/total
    @GetMapping(value = "/total", produces = "application/json")
    public ResponseEntity<?> GetTotal(){
        List<PiggyBankCoin> piggyBankContains = new ArrayList<>();

        int dollar = 0;
        int quarter = 0;
        int dime = 0;
        int nickel = 0;
        int penny = 0;

        double totalValue = 0;

        PiggyBankRepo.findAll().iterator().forEachRemaining(piggyBankContains::add);

        for(PiggyBankCoin coins: piggyBankContains){
            switch (coins.getName().toLowerCase()){
                case "dollar":
                {
                    dollar += coins.getQuantity();
                    totalValue += (coins.getQuantity() * coins.getValue());
                    break;
                }
                case "quarter":
                {
                    quarter += coins.getQuantity();
                    totalValue += (coins.getQuantity() * coins.getValue());
                    break;
                }
                case "dime":
                {
                    dime =+ coins.getQuantity();
                    totalValue += (coins.getQuantity() * coins.getValue());
                    break;
                }
                case "nickel":
                {
                    nickel += coins.getQuantity();
                    totalValue += (coins.getQuantity() * coins.getValue());
                    break;
                }
                case "penny":
                {
                    penny += coins.getQuantity();
                    totalValue += (coins.getQuantity() * coins.getValue());
                    break;
                }
                default:
                    System.out.println(coins.getName() + " is not a type of coin.");
                    break;

            }


        }

        /*
        * I understand I could have done this with fewer lines of code in the for each loop by having it
        * System.out.println(coins.getQuantity() + "" + coins.getNameplural())
        * totalValue += (coins.getQuantity() * coins.getValue())
        * I chose to do this as It is a bit cleaner in the long run for example if we had 1000 coins in the piggy bank
        * the format that was requested would be to cumbersome to know how many of each coin
        * */

        System.out.println(dollar + " Dollars");
        System.out.println(quarter + " Quarters");
        System.out.println(dime + " Dimes");
        System.out.println(nickel + " Nickels");
        System.out.println(penny + " Pennies");
        System.out.println("The piggy bank holds "+ totalValue);
        return null;
    }
}
