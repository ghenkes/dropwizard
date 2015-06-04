package io.dropwizard.jersey.setup;

public class JerseyContainerHolder {
    private JerseyServletContainer container;

    public JerseyContainerHolder(JerseyServletContainer container) {
        this.container = container;
    }

    public JerseyServletContainer getContainer() {
        return container;
    }

    public void setContainer(JerseyServletContainer container) {
        this.container = container;
    }
}
