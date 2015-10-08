# grails-springsecurity3-websockets

This is a Grails plugin for the [3.2 backport](https://github.com/northstratinc/springsecurity3-websockets) of Spring Security 4.0 websocket security

## Usage

Until this plugin is available in the Grails Plugin repository, you will also have to clone this repo and maven-install the plugin

```bash
git clone git@github.com:northstratinc/grails-springsecurity3-websockets.git
cd grails-springsecurity3-websockets
grails compile
grails maven-install
```

Now you can add it to your `BuildConfig.groovy`

```groovy
plugins {
    compile ":springsecurity3-websockets:0.1-SNAPSHOT"
}
```

## Configuration

#### InterceptDestinationMap

To get started with configuration, simply add the following configuration to your `Config.groovy`

```groovy
grails.plugin.springsecurity3.websockets.interceptDestinationMap = [
        "/**":               "isAuthenticated()"
]
```

This example configuration is not very restrictive at all, so you should probably remove it and add message patterns and expressions as necessary. See the [Intercept Destination Map](https://github.com/northstratinc/springsecurity3-websockets#intercept-destination-map) section on the springsecurity3-websockets README for more information on the message pattern and security expression syntax

#### Reject If No Rule

By default, the web socket channel security interceptor will not reject a message if there is no rule present. In other words, any message that _doesn't_ match a rule in the `interceptDestinationMap` will be allowed by default. To flip this behavior (_deny_ any message that does not match a rule), simply add the following configuration:

```groovy
grails.plugin.springsecurity3.websockets.rejectIfNoRule = true
```
