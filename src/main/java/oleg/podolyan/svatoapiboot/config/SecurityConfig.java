package oleg.podolyan.svatoapiboot.config;

import oleg.podolyan.svatoapiboot.hidden.SecurityUtility;
import oleg.podolyan.svatoapiboot.service.security.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Autowired
    private UserSecurityService userSecurityService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
    }

//    private final static String [] PUBLIC_MATCHERS = {
//                                    "/ccs/**",
//                                    "/js/**",
//                                    "/image/**",
//                                    "/book/**",
//                                    "/user/**"
//    };

    private static final String [] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/",
            "/about/**",
            "/contact/**",
            "/error/**/*",
            "/console/**",
            "/signup"
    };

    private BCryptPasswordEncoder passwordEncoder(){
        return SecurityUtility.passwordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests()
//        .antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest()
//        .authenticated();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/**")
                .antMatchers(PUBLIC_MATCHERS)
                .permitAll().anyRequest().authenticated();
        http
                .csrf().disable().cors().disable()
                .formLogin().failureUrl("/index?error").defaultSuccessUrl("/index").loginPage("/index").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index?loguot").deleteCookies("remember-me").permitAll()
                .and()
                .rememberMe();
    }

    @Bean
    public HttpSessionStrategy httpSessionStrategy(){
        return new HeaderHttpSessionStrategy();
    }


}
