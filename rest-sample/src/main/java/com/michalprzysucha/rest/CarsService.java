package com.michalprzysucha.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * @author Michal Przysucha
 * @since 2014-11-09
 */
@Path("/cars")
@Consumes(MediaType.APPLICATION_JSON)
public class CarsService {

    private static final Logger logger = Logger.getLogger(CarsService.class.getName());

    @PATCH
    @Path("/gear")
    public Response repair(Gear gear) {
        logger.info(gear + "");
        return Response.ok().build();
    }

    @PUT
    @Path("/gear")
    public Response change(Gear gear) {
        logger.info(gear + "");
        return Response.ok().build();
    }

}
