package xyz.lysean.spring.config


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean

@ConditionalOnProperty('jenkins.url')
class JenkinsProperties {

}
