package name.taolei.zealot.test.springboot.dubbo.zookeeper.use;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

import javax.management.MalformedObjectNameException;
import java.nio.charset.Charset;

@Configuration
@PropertySource("classpath:webServer.properties")
public class TomcatWebServerConfig {
    @Autowired
    private Environment environment;

    @Bean
    public EmbeddedServletContainerFactory createEmbeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();
        tomcatFactory.setPort(Integer.valueOf(environment.getProperty("tomcat.port")));
        tomcatFactory.setUriEncoding(Charset.forName(environment.getProperty("tomcat.charset")));
        tomcatFactory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            public void customize(Connector connector) {
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                //设置最大连接数
                protocol.setMaxConnections(Integer.valueOf(environment.getProperty("tomcat.maxConnections")));
                //设置最大线程数
                protocol.setMaxThreads(Integer.valueOf(environment.getProperty("tomcat.maxThreads")));
                protocol.setConnectionTimeout(Integer.valueOf(environment.getProperty("tomcat.timeout")));
            }
        });
        return tomcatFactory;
    }

    @Bean
    public RmiRegistryFactoryBean rmiRegistry() {
        RmiRegistryFactoryBean rmiRegistryFactoryBean = new RmiRegistryFactoryBean();
        rmiRegistryFactoryBean.setPort(Integer.valueOf(environment.getProperty("tomcat.jmx.port")));
        rmiRegistryFactoryBean.setAlwaysCreate(true);
        return rmiRegistryFactoryBean;
    }

    @Bean
    @DependsOn("rmiRegistry")
    public ConnectorServerFactoryBean connectorServerFactoryBean() throws MalformedObjectNameException {
        ConnectorServerFactoryBean connectorServerFactoryBean = new ConnectorServerFactoryBean();
        connectorServerFactoryBean.setObjectName("connector:name=rmi");
        connectorServerFactoryBean.setServiceUrl(
                String.format("service:jmx:rmi://%s:%s/jndi/rmi://%s:%s/jmxrmi", environment.getProperty("tomcat.jmx.host"), environment.getProperty("tomcat.jmx.port"), environment.getProperty("tomcat.jmx.host"), environment.getProperty("tomcat.jmx.port")));
        return connectorServerFactoryBean;
    }
}