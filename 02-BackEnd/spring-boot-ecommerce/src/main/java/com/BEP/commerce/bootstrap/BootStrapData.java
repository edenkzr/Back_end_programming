package com.BEP.commerce.bootstrap;

import com.BEP.commerce.dao.CustomerRepository;
import com.BEP.commerce.dao.DivisionRepository;
import com.BEP.commerce.entities.Customer;
import com.BEP.commerce.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //check repository
        if (customerRepository.count() < 6) {

            //create division
            Division arizona = new Division();
            arizona.setId(2L);

            //create customers
            Customer barry = new Customer("Barry", "Allen", "Central City", "33028", "3056035190", arizona);
            Customer bruce = new Customer("Bruce", "Wayne", "Gotham", "33154", "7865478998", arizona);
            Customer clark = new Customer("Clark", "Kent", "Metropolis", "14234", "9546771829", arizona);
            Customer oliver = new Customer("Oliver", "Queen", "Star City", "45271", "3056062913", arizona);
            Customer diana = new Customer("Diana", "Prince", "Themyscira", "31787", "3056200748", arizona);

            //add customers to division
            arizona.getCustomers().add(barry);
            arizona.getCustomers().add(bruce);
            arizona.getCustomers().add(clark);
            arizona.getCustomers().add(oliver);
            arizona.getCustomers().add(diana);

            //save customers
            customerRepository.save(barry);
            customerRepository.save(bruce);
            customerRepository.save(clark);
            customerRepository.save(oliver);
            customerRepository.save(diana);

        }
    }
}
