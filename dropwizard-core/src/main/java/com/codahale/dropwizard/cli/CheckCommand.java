package com.codahale.dropwizard.cli;

import com.codahale.dropwizard.Configuration;
import com.codahale.dropwizard.Service;
import com.codahale.dropwizard.setup.Bootstrap;
import net.sourceforge.argparse4j.inf.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckCommand<T extends Configuration> extends ConfiguredCommand<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckCommand.class);

    private final Class<T> configurationClass;

    public CheckCommand(Service<T> service) {
        super("check", "Parses and validates the configuration file");
        this.configurationClass = service.getConfigurationClass();
    }

    /*
     * Since we don't subclass CheckCommand, we need a concrete reference to the configuration
     * class.
     */
    @Override
    protected Class<T> getConfigurationClass() {
        return configurationClass;
    }

    @Override
    protected void run(Bootstrap<T> bootstrap,
                       Namespace namespace,
                       T configuration) throws Exception {
        LOGGER.info("Configuration is OK");
    }
}
