# StatTracker #
***

## Description: ##

Tracks various statistics over the lifetime of a bukkit minecraft server and saves them in stats.txt

## List of statistics tracked: ##

-  Arrows Fired
-  Blocks Broke
-  Blocks Burned
-  Blocks Placed
-  Eggs Thrown
-  Items Crafted
-  Mobs Killed
-  Player Deaths
-  Players Joined
-  Snowballs Thrown

## Usage: ##

### Plugin: ###

1.  Compile the source code to create the plugin jar, make sure to include config.yml & plugin.yml in the jar.
2.  Place the plugin jar in the *plugins* directory of the bukkit server.
3.  Once the server has loaded the plugin, a config file will have been created at *plugins/StatTracker/config.yml*.

### Sinatra Server: ###

Requirements:

-  [Ruby](http://www.ruby-lang.org/en/) 1.9.2 *or* 1.9.3
-  [Sinatra gem](http://www.sinatrarb.com/)

Server use:

1.  Add the files within *sinatra_app* to the root directory of bukkit.
2.  Use the command "ruby app.rb" to start the server.
3.  Navigate to %serverdomain%:4567 to view the website.

## Licensing: ##

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_US"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-nc-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_US">Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License</a>.

Contact me if you have any questions: *chase4926* (at) *gmail.com*
