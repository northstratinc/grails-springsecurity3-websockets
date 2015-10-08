import com.northstrat.springsecurity.web.socket.DefaultSecurityWebSocketMessageBrokerConfigurer
import grails.util.Environment
import org.codehaus.groovy.grails.commons.GrailsApplication

class Springsecurity3WebsocketsGrailsPlugin {
    // the plugin version
    def version = "0.1-SNAPSHOT"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.5 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = []

    // TODO Fill in these fields
    def title = "Springsecurity3 Websockets Plugin" // Headline display name of the plugin
    def author = "Ryan Lanman"
    def authorEmail = "ryan.lanman@northstrat.com"
    def description = '''\
Grails wrapper around a minimal backport of the Websocket Security features of Spring Security 4.0
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/springsecurity3-websockets"

    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
    def organization = [ name: "Northstrat Inc.", url: "http://www.northstrat.com/" ]

    // Any additional developers beyond the author specified above.
    def developers = [ [ name: "Ryan Lanman", email: "ryan.lanman@northstrat.com" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "Github", url: "http://github.com/northstratinc/grails-springsecurity3-websockets/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "http://github.com/northstratinc/grails-springsecurity3-websockets" ]


    def doWithSpring = {
        def conf = application.config.grails.plugin.springsecurity3.websockets

        securityWebSocketConfigurer(DefaultSecurityWebSocketMessageBrokerConfigurer) {
            interceptDestinationMap = conf.interceptDestinationMap ?: [:]

            if (conf.rejectIfNoRule instanceof Boolean) {
                rejectIfNoRule = conf.rejectIfNoRule
            }
        }
    }
}
