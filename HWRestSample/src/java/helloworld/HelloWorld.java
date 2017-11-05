/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author pauloricardo
 */
@Path("helloworld")
public class HelloWorld {

    @Context
    private UriInfo context;
    
    @EJB
    GuardaNomeBean gnb;

    /**
     * Creates a new instance of HelloWorld
     */
    public HelloWorld() {
    }

    /**
     * Retrieves representation of an instance of helloworld.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        return "<html lang=\"en\"><body><h1>Hello, World!!</body></h1></html>";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(){
        return "{\"exclamation\":\"hello world!!!\"}";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getNome(){
        return "{\"name\":\""+gnb.getNome()+"\"}";
    }
    
    /**
     * PUT method for updating or creating an instance of HelloWorld
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {}
    
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void setNome(String nome){
        gnb.setNome(nome);
    }
}
