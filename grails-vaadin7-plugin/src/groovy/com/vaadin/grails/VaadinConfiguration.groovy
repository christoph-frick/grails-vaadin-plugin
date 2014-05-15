package com.vaadin.grails

import grails.util.Environment
import grails.util.Holders
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

/**
 * Manages user defined VaadinConfig class.
 *
 * @author Ondrej Kvasnovsky
 */
@Slf4j
@CompileStatic
class VaadinConfiguration {

    private static final String VAADIN_CONFIG_FILE = "VaadinConfig"

    ConfigObject configuration = null;

    def getConfig() {
        if (configuration == null) {
            ClassLoader loader = Holders.grailsApplication.getClassLoader()
            try {
                Class configFile = loader.loadClass(VAADIN_CONFIG_FILE);
                configuration = new ConfigSlurper(Environment.current.name).parse(configFile);
            } catch (ClassNotFoundException e) {
                log.warn "Unable to find Vaadin plugin config file: ${VAADIN_CONFIG_FILE}.groovy"
            }
        }
        def res = configuration?.vaadin
        return res;
    }
}
