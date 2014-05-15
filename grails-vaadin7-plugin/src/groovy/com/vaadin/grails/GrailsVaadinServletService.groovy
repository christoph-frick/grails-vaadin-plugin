package com.vaadin.grails

import com.vaadin.server.VaadinServletService
import com.vaadin.server.VaadinServlet
import com.vaadin.server.DeploymentConfiguration
import grails.util.Holders
import groovy.transform.CompileStatic

/**
 *
 *
 * @author Ondrej Kvasnovsky
 */
@CompileStatic
class GrailsVaadinServletService extends VaadinServletService {

    GrailsVaadinServletService(VaadinServlet servlet, DeploymentConfiguration deploymentConfiguration) {
        super(servlet, deploymentConfiguration)
    }

    @Override
    ClassLoader getClassLoader() {
        ClassLoader loader = Holders.grailsApplication.getClassLoader()
        return loader
    }
}
