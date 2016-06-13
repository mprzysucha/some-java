package com.michalprzysucha.rest;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Michal Przysucha
 * @since 2014-11-09
 */
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(CarsService.class);
        return set;
    }

}
