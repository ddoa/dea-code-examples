/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassfish.samples;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.glassfish.samples.entities.Customer;

/**
 *
 * @author mdkr
 */
@Stateless
@LocalBean
@javax.inject.Named
@Path("/customers")
public class CustomerSessionBean {

    @PersistenceContext
    EntityManager em;

    public List<Customer> getCustomers() {
        return (List<Customer>) em.createNamedQuery("Customer.findAll").getResultList();
    }

    @GET
    @Path("/customer/{id}")
    @Produces({"application/xml", "application/json"})
    public Customer getCustomer(@PathParam("id") Integer id) {
        return (Customer) em.createNamedQuery("Customer.findByCustomerId").setParameter("customerId", id).getSingleResult();
    }
}
