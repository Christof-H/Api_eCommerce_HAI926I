package com.android.ecommerce.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Classe de configuration pour l'application Spring.
 *
 * Cette classe définit des beans pour les messages et une Factory de validation.
 * Les beans de messages sont utilisés pour configurer les messages d'erreur et de validation.
 * La factory de validation pour les annotations de validation au sein de l'application.
 */
@Configuration
public class MessageConfig {
    
    /**
     * Définit un bean de SourceMessage pour les messages d'erreur.
     *
     * Cette méthode crée un ResourceBundleMessageSource qui lit les messages d'erreur
     * depuis un bundle de ressources nommé 'errormessage'. Elle définit l'encodage par défaut sur UTF-8.
     *
     * @return Un MessageSource qui peut être utilisé pour résoudre les messages d'erreur.
     */
    @Bean(name = "errorMessageSource")
    public MessageSource errorMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("errormessage");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
    /**
     * Définit un bean de source de messages pour les messages de validation.
     *
     * Cette méthode crée un ReloadableResourceBundleMessageSource qui lit les messages de validation
     * depuis un bundle de ressources. 
     * Le bundle de ressources est situé à 'classpath:validationmessage' et utilise l'encodage UTF-8.
     *
     * @return Un MessageSource qui peut être utilisé pour résoudre les messages de validation.
     */
    @Bean(name = "validationMessageSource")
    public MessageSource validationMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:validationmessage");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * Définit un LocalValidatorFactoryBean qui utilise le MessageSource spécifié.
     *
     * Ce bean est configuré pour utiliser le validationMessageSource pour résoudre les messages de validation.
     * Il s'intègre à l'API standard de validation des beans et est utilisé pour valider les objets
     * basés sur des contraintes définies via des annotations.
     *
     * @param messageSource Le MessageSource à utiliser pour résoudre les messages de validation.
     *                      Devrait être une référence à 'validationMessageSource'.
     * @return Un LocalValidatorFactoryBean configuré qui utilise le MessageSource spécifié.
     */
    @Bean
    public LocalValidatorFactoryBean validator(@Qualifier("validationMessageSource") MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }
}
