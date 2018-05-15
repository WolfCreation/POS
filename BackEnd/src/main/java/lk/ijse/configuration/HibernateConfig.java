package lk.ijse.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
@SuppressWarnings("ALL")
@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    @Autowired
    @Qualifier("dataSource")
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setPackagesToScan(new String[] {"lk.ijse.domain"});
        Properties props = new Properties();
        props.setProperty("dialect","org.hibernate.dialect.MySQL5Dialect");
        sfb.setHibernateProperties(props);
        return sfb;
    }


    @Autowired
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sf){
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sf);
        return htm;
    }

}
